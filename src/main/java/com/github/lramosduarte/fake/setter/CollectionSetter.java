package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserGenerics;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.data.TypesToGenerate;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;


public class CollectionSetter implements Setter, AnalyserGenerics {

    private final FakeDataGenerator fakeDataGenerator;

    public CollectionSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException {
        attribute.field.setAccessible(true);
        Collection collection = new LinkedList();
        TypesToGenerate typeParam =
            this.analyseParamsGenerics((ParameterizedType) attribute.field.getGenericType(), 1).get(0);
        for (int i = 0; i < attribute.type.size(); i++) {
            collection.add(this.fakeDataGenerator.make(Attribute.ofTypesToGenerate(typeParam)));
        }
        try {
            attribute.field.set(object, collection);
        } catch (IllegalArgumentException ignored) {
            attribute.field.set(object, new HashSet<>(collection));
        }
    }

}
