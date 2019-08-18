package com.lramosduarte.fake;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lramosduarte.classutils.SimpleClassAttributesObjects;


public class FakeDataGeneratorIgnoreAttributesTest {

    private static FakeDataGenerator generator;

    @BeforeAll
    public static void setUpAll() {
        FakeDataGeneratorIgnoreAttributesTest.generator = FakeDataGenerator.getInstance();
    }

    @Test
    public void testGeneratorFakeDataAndIgnoreAttributePassInList_returnObjectWithoutValueInAttribute() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        HashSet<String> attributesToIgnore = new HashSet<String>() {{ add("atrChar"); }};
        SimpleClassAttributesObjects clsObject = FakeDataGeneratorIgnoreAttributesTest.generator.makeAndIgnore(
            SimpleClassAttributesObjects.class, attributesToIgnore
        );
        Assertions.assertNull(clsObject.atrChar);
    }

}
