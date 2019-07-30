package com.lramosduarte.analyser;

import com.lramosduarte.SimpleClassAttributesPrimitives;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AnalyserTestCase {

    private static Iterable<Attribute> attributes;
    private static Attribute attribute;

    @BeforeAll
    public static void setUp() throws ClassNotFoundException {
        AnalyserTestCase.attributes = AnalyserImp.getAnalyser().analyse(SimpleClassAttributesPrimitives.class);
        AnalyserTestCase.attribute = attributes.iterator().next();
    }

    @Test
    public void testAnalyseClassPrimitesValues_returnName() {
        Assertions.assertEquals("atrBool", AnalyserTestCase.attribute.name);
    }

    @Test
    public void testAnalyseClassPrimitesValues_returnType() {
        Assertions.assertEquals(TypesToGenerate.BOOL, AnalyserTestCase.attribute.type);
    }

    @Test
    public void testAnalyseClassPrimitesValues_returnObjectField() {
        Assertions.assertNotNull(AnalyserTestCase.attribute.type);
    }

}
