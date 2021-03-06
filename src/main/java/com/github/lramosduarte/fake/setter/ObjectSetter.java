package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;


public class ObjectSetter implements Setter {

    private final FakeDataGenerator fakeDataGenerator;

    public ObjectSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        attribute.field.setAccessible(true);
        attribute.field.set(object, fakeDataGenerator.make(attribute.field.getType()));
    }

}
