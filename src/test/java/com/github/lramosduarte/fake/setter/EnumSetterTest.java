package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.ClassWithDictionarys;
import com.github.lramosduarte.classutils.ClassWithEnum;
import com.github.lramosduarte.classutils.TypeEnum;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class EnumSetterTest {

    private static Iterable<Attribute> attributes;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        EnumSetterTest.attributes = AnalyserImp.getAnalyser().analyse(ClassWithEnum.class);
    }

    @Test
    public void testDictionarySetterSetValueMap_returnAttributeMapNotNull() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Iterator<Attribute> iteratorAttributes = attributes.iterator();
        Attribute attributeMap = iteratorAttributes.next();
        ClassWithEnum cls = new ClassWithEnum();
        new EnumSetter(FakeDataGenerator.getInstance()).setAttribute(attributeMap, cls);
        Assertions.assertNotNull(cls.getAtrEnum());
    }

}
