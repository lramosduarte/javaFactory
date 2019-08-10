package com.lramosduarte.fake.setter;

import com.lramosduarte.analyser.AnalyserImp;
import com.lramosduarte.classutils.ClassWithDictionarys;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class DictionarySetterTest {

    private static Iterable<Attribute> attributes;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        DictionarySetterTest.attributes = AnalyserImp.getAnalyser().analyse(ClassWithDictionarys.class);
    }

    @Test
    public void testDictionarySetterSetValueMap_returnAttributeMapNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        Attribute attributeMap = iteratorAttributes.next();
        ClassWithDictionarys cls = new ClassWithDictionarys();
        new DictionarySetter(FakeDataGenerator.getInstance()).setAttribute(attributeMap, cls);
        Assertions.assertNotNull(cls.getAtrDictionary());
    }

}
