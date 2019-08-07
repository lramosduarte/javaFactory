package com.lramosduarte.fake.setter;

import com.lramosduarte.analyser.AnalyserImp;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;


public class ShortSetterTest {

    public class ShortClass {
        Short atrObject;
        short atrPrimitive;
    }

    public static Attribute attributeObjectShort;

    public static Attribute attributePrimitiveShort;

    @BeforeAll
    public static void setUpAll() throws ClassNotFoundException {
        Iterable<Attribute> attributes = AnalyserImp.getAnalyser().analyse(ShortSetterTest.ShortClass.class);
        Iterator i = attributes.iterator();
        ShortSetterTest.attributeObjectShort = (Attribute) i.next();
        ShortSetterTest.attributePrimitiveShort = (Attribute) i.next();
    }

    @Test
    public void testShortObjectInstanceSetValue_returnVariableWithValue() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ShortClass obj = new ShortClass();
        new ShortSetter(FakeDataGenerator.getInstance()).setAttribute(ShortSetterTest.attributeObjectShort, obj);
        Assertions.assertNotNull(obj.atrObject);
    }

    @Test
    public void testShortPrimitiveSetValue_returnVariableWithValue() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ShortClass obj = new ShortClass();
        short value = obj.atrPrimitive;
        new ShortSetter(FakeDataGenerator.getInstance()).setAttribute(ShortSetterTest.attributePrimitiveShort, obj);
        Assertions.assertNotEquals(value, obj.atrPrimitive);
    }

}
