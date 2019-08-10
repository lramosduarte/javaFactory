package com.lramosduarte.fake;

import com.google.common.collect.ImmutableMap;

import com.lramosduarte.analyser.Analyser;
import com.lramosduarte.analyser.AnalyserImp;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import com.lramosduarte.exception.GenerateValueException;
import com.lramosduarte.fake.generator.BoolGenerator;
import com.lramosduarte.fake.generator.CharGenerator;
import com.lramosduarte.fake.generator.Generator;
import com.lramosduarte.fake.generator.NumberGenerator;
import com.lramosduarte.fake.generator.StringGenerator;
import com.lramosduarte.fake.setter.CollectionSetter;
import com.lramosduarte.fake.setter.DefaultSetter;
import com.lramosduarte.fake.setter.DictionarySetter;
import com.lramosduarte.fake.setter.ObjectSetter;
import com.lramosduarte.fake.setter.ShortSetter;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.StreamSupport;


public class FakeDataGenerator {

    private static FakeDataGenerator instance;

    private Analyser analyser;

    private FakeDataGenerator() {
        this.analyser = AnalyserImp.getAnalyser();
    };

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
        Iterable<Attribute> attributes = this.analyser.analyse(cls);
        ObjectClass objectClass = (ObjectClass) cls.newInstance();
        StreamSupport.stream(attributes.spliterator(), false).forEach(a -> {
            try {
                this.setAttributeValue(a, objectClass);
            } catch (ReflectiveOperationException ex) {
                throw new GenerateValueException(ex);
            }

        });
        return objectClass;
    }

    private <Instance> void setAttributeValue(Attribute attribute, Instance object) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (TypesToGenerate.OBJECT.equals(attribute.type)) {
            new ObjectSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.isShort(attribute.field.getType())) {
            new ShortSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.COLLECTION.equals(attribute.type)) {
            new CollectionSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        } else if (TypesToGenerate.DICTIONARY.equals(attribute.type)) {
            new DictionarySetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
            return;
        }
        new DefaultSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, object);
    }

    public static FakeDataGenerator getInstance() {
        if (FakeDataGenerator.instance == null) {
            FakeDataGenerator.instance = new FakeDataGenerator();
        }
        return FakeDataGenerator.instance;
    }

}
