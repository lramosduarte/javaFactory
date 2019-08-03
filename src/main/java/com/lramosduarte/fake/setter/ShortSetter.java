package com.lramosduarte.fake.setter;

import com.lramosduarte.data.Attribute;
import com.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.InvocationTargetException;


public class ShortSetter implements Setter {

    private final FakeDataGenerator fakeDataGenerator;

    public ShortSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.setAccessibilityAttribute(attribute);
        Object value = this.fakeDataGenerator.make(attribute.type);
        attribute.field.set(object, Number.class.getMethod("shortValue").invoke(value));
    }

}
