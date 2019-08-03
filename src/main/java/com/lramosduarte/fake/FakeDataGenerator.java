package com.lramosduarte.fake;

import com.google.common.collect.ImmutableMap;
import com.lramosduarte.analyser.Analyser;
import com.lramosduarte.analyser.AnalyserImp;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import com.lramosduarte.exception.AccessAtributeException;
import com.lramosduarte.exception.GenerateValueException;

import java.lang.reflect.Constructor;
import java.util.stream.StreamSupport;


public class FakeDataGenerator {

    private ImmutableMap<TypesToGenerate, Generator> MAP_GENERATOR = ImmutableMap.of(
        TypesToGenerate.BOOL, new BoolGenerator(),
        TypesToGenerate.CHAR, new CharGenerator(),
        TypesToGenerate.SMALL_TEXT, new StringGenerator(),
        TypesToGenerate.BIG_TEXT, new StringGenerator(),
        TypesToGenerate.NUMBER, new NumberGenerator()
    );

    public <TypeObject> TypeObject make(TypesToGenerate type) {
        return (TypeObject) this.MAP_GENERATOR.get(type).generate(type.size());
    }

    public <ObjectClass> ObjectClass make(Class<?> cls) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Analyser analyser = AnalyserImp.getAnalyser();
        Iterable<Attribute> attributes = analyser.analyse(cls);
        ObjectClass objectClass = (ObjectClass) cls.newInstance();
        StreamSupport.stream(attributes.spliterator(), false).forEach(a -> {
            this.setAttributeValue(a, objectClass);
        });
        return objectClass;
    }

    private <Instance> void setAttributeValue(Attribute attribute, Instance object) {
        attribute.field.setAccessible(true);
        if (TypesToGenerate.OBJECT.equals(attribute.type)) {
            try {
                attribute.field.set(object, this.make(attribute.field.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return;
        }
        Object value = this.make(attribute.type);
        if (TypesToGenerate.isShort(attribute.field.getType())) {
            try {
                attribute.field.set(object, Number.class.getMethod("shortValue").invoke(value));
            } catch (ReflectiveOperationException ex) {
                throw new GenerateValueException(ex);
            }
            return;
        }
        try {
            attribute.field.set(object, value);
        } catch (IllegalArgumentException e) {
            Constructor<?> constructor = null;
            try {
                constructor = attribute.field.getType().getConstructor(String.class);
            } catch (NoSuchMethodException ignored) { }

            try {
                attribute.field.set(object, constructor.newInstance(value.toString()));
            } catch (ReflectiveOperationException ex) {
                throw new GenerateValueException(ex);
            }
        } catch (IllegalAccessException ex) {
            throw new AccessAtributeException(ex);
        }
        return;
    }

}
