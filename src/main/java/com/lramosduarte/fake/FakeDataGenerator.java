package com.lramosduarte.fake;

import com.google.common.collect.ImmutableMap;
import com.lramosduarte.analyser.Analyser;
import com.lramosduarte.analyser.AnalyserImp;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import com.lramosduarte.exception.AccessAttributeException;
import com.lramosduarte.exception.InvocationException;
import com.lramosduarte.exception.MethodNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    private <Object> void setAttributeValue(Attribute attribute, Object object) {
        attribute.field.setAccessible(true);
        if (TypesToGenerate.NUMBER.equals(attribute.type)) {
            Method convertNumber;
            try {
                convertNumber = Integer.class.getMethod( attribute.field.getType().getSimpleName() + "Value");
            }
            catch (NoSuchMethodException e) { throw new MethodNotFoundException(e); }
            try {
                attribute.field.set(object, convertNumber.invoke(this.make(attribute.type)));
            }
            catch (InvocationTargetException ex) { throw new InvocationException(ex); }
            catch (IllegalAccessException ex) { throw new AccessAttributeException(ex); }
        } else {
            try {
                attribute.field.set(object, this.make(attribute.type));
            }
            catch (IllegalAccessException ex) { throw new AccessAttributeException(ex); }
        }
    }

}
