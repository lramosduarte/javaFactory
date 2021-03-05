package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.ClassDatetimeObjects;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class DateTimeSetterTest {

    private static Iterable<Attribute> attributes;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        DateTimeSetterTest.attributes = AnalyserImp.getAnalyser().analyse(ClassDatetimeObjects.class);
    }

    @Test
    public void testDictionarySetterSetLocalDateValue_returnAttributeLocalDateNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        Attribute attributeLocalDate = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeLocalDate, cls);
        Assertions.assertNotNull(cls.getAtrLocalDate());
    }

    @Test
    public void testDictionarySetterSetLocalDateTimeValue_returnAttributeLocalDateTimeNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        Attribute attributeLocalDateTime = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeLocalDateTime, cls);
        Assertions.assertNotNull(cls.getAtrLocalDateTime());
    }

    @Test
    public void testDictionarySetterSetatrLocalTimeValue_returnAttributeatrLocalTimeNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        iteratorAttributes.next();
        Attribute attributeLocalTime = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeLocalTime, cls);
        Assertions.assertNotNull(cls.getAtrLocalTime());
    }

    @Test
    public void testDictionarySetterSetZonedLocalDateTimeValue_returnAttributeZonedLocalDateTimeNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        Attribute attributeZonedLocalDateTime = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeZonedLocalDateTime, cls);
        Assertions.assertNotNull(cls.getAtrZonedDateTime());
    }

    @Test
    public void testDictionarySetterSetMonthValue_returnAttributeMonthNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        Attribute attributeMonth = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeMonth, cls);
        Assertions.assertNotNull(cls.getAtrMonth());
    }

    @Test
    public void testDictionarySetterSetDayOfWeekValue_returnAttributeDayOfWeekNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        iteratorAttributes.next();
        Attribute attributeDayOfWeek = iteratorAttributes.next();
        ClassDatetimeObjects cls = new ClassDatetimeObjects();
        new DateTimeSetter(FakeDataGenerator.getInstance()).setAttribute(attributeDayOfWeek, cls);
        Assertions.assertNotNull(cls.getAtrDayOfWeek());
    }

}
