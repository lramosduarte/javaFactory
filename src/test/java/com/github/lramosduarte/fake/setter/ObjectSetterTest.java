package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.ClassUsingLombok;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.classutils.ClassWithNestedObjects;
import com.github.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ObjectSetterTest {

    public static Attribute attribute;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        Iterable<Attribute> attributes = AnalyserImp.getAnalyser().analyse(ClassWithNestedObjects.class);
        attribute = attributes.iterator().next();
    }

    @Test
    public void testObjectSetterSetValue_returnVariableWithValue() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ClassWithNestedObjects cls = new ClassWithNestedObjects();
        new ObjectSetter(FakeDataGenerator.getInstance()).setAttribute(ObjectSetterTest.attribute, cls);
        Assertions.assertNotNull(cls.objLombok);
    }

    @Test
    public void testObjectSetterSetValue_returnObjectHasAttributeWithValue() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ClassWithNestedObjects cls = new ClassWithNestedObjects();
        cls.objLombok = new ClassUsingLombok();
        String value = cls.objLombok.getAtrString();
        new ObjectSetter(FakeDataGenerator.getInstance()).setAttribute(ObjectSetterTest.attribute, cls);
        Assertions.assertNotEquals(value, cls.objLombok.getAtrString());
    }

}
