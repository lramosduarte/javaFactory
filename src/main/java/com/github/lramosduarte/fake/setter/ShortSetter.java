package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.InvocationTargetException;


public class ShortSetter implements Setter {

    private final FakeDataGenerator fakeDataGenerator;

    public ShortSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        attribute.field.setAccessible(true);
        Object value = this.fakeDataGenerator.make(attribute);
        attribute.field.set(object, Number.class.getMethod("shortValue").invoke(value));
    }

}
