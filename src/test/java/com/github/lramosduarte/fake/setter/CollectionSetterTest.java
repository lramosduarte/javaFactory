package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.ClassWithCollections;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class CollectionSetterTest {

    private static Iterable<Attribute> attributes;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        CollectionSetterTest.attributes = AnalyserImp.getAnalyser().analyse(ClassWithCollections.class);
    }

    @Test
    public void testCollectionSetterSetListValue_returnAttributeListNotNull() throws IllegalAccessException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        Attribute attributeList = iteratorAttributes.next();
        ClassWithCollections cls = new ClassWithCollections();
        new CollectionSetter(FakeDataGenerator.getInstance()).setAttribute(attributeList, cls);
        Assertions.assertNotNull(cls.getAtrList());
    }

    @Test
    public void testCollectionSetterSetSetValue_returnAttributeSetNotNull() throws IllegalAccessException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        iteratorAttributes.next();
        Attribute attributeSet = iteratorAttributes.next();
        ClassWithCollections cls = new ClassWithCollections();
        new CollectionSetter(FakeDataGenerator.getInstance()).setAttribute(attributeSet, cls);
        Assertions.assertNotNull(cls.getAtrSet());
    }

}
