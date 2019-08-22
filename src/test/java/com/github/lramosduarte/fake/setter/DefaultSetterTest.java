package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.SimpleClassAttributesObjects;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;


public class DefaultSetterTest {

    @Test
    public void testDefaultSetterSetValue_returnVariableNotNull() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        Iterable<Attribute> attributes = AnalyserImp.getAnalyser().analyse(SimpleClassAttributesObjects.class);
        Attribute attribute = attributes.iterator().next();
        SimpleClassAttributesObjects cls = new SimpleClassAttributesObjects();
        new DefaultSetter(FakeDataGenerator.getInstance()).setAttribute(attribute, cls);
        Assertions.assertNotNull(cls.atrChar);
    }

    @Test
    public void testDefaultSetterSetValueNeedSetValueWithConstructor_returnVariableNotNull() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        Attribute attributeBigDecimal = null;
        Iterator<Attribute> i = AnalyserImp.getAnalyser().analyse(SimpleClassAttributesObjects.class).iterator();
        while (i.hasNext()) {
            attributeBigDecimal = i.next();
        }
        SimpleClassAttributesObjects cls = new SimpleClassAttributesObjects();
        new DefaultSetter(FakeDataGenerator.getInstance()).setAttribute(attributeBigDecimal, cls);
        Assertions.assertNotNull(cls.atrBigDecimal);
    }

}
