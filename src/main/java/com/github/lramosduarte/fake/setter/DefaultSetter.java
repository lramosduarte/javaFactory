package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class DefaultSetter implements Setter {

    private final FakeDataGenerator fakeDataGenerator;

    public DefaultSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        attribute.field.setAccessible(true);
        Object value = this.fakeDataGenerator.make(attribute);
        try {
            attribute.field.set(object, value);
        } catch (IllegalArgumentException ignored) {
            Constructor<?> constructor = attribute.field.getType().getConstructor(String.class);
            attribute.field.set(object, constructor.newInstance(value.toString()));
        }
    }

}
