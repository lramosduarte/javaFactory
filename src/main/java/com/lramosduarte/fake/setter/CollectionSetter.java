package com.lramosduarte.fake.setter;

import com.lramosduarte.analyser.AnalyserGenerics;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import com.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


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
            collection.add(this.fakeDataGenerator.make(typeParam));
        }
        try {
            attribute.field.set(object, collection);
        } catch (IllegalArgumentException ignored) {
            attribute.field.set(object, new HashSet<>(collection));
        }
    }

}
