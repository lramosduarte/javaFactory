package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserGenerics;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.util.Random;


public class EnumSetter implements Setter, AnalyserGenerics {

    private final FakeDataGenerator fakeDataGenerator;

    public EnumSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        attribute.field.setAccessible(true);
        Class<Enum> enumToPopulate = ((Class<Enum>)Class.forName(attribute.field.getType().getName()));
        Enum[] valuesEnum = enumToPopulate.getEnumConstants();
        Integer valueRandomForEnum = new Random().ints(1, 0, valuesEnum.length).findFirst().getAsInt();
        attribute.field.set(object, Enum.valueOf(enumToPopulate, valuesEnum[valueRandomForEnum].name()));
    }

}
