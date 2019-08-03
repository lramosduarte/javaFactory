package com.lramosduarte.fake;

import com.lramosduarte.classutils.ClassWithNestedObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorNestedObjectsTest {

    private static ClassWithNestedObjects objectWithNestedObjects;

    @BeforeAll
    public static void setUp() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        FakeDataGeneratorNestedObjectsTest.objectWithNestedObjects =
            FakeDataGenerator.getInstance().make(ClassWithNestedObjects.class);
    }

    @Test
    public void testGenerateObjectWithNestedObjects_returnInstanceWithSuccess() {
        ClassWithNestedObjects object = new ClassWithNestedObjects();
        Assertions.assertNotNull(object);
    }

    @Test
    public void testGenerateNestedObject_returnNestedObjectWithValues() {
        boolean attributesNotNull = (
            objectWithNestedObjects.objLombok != null &&
            objectWithNestedObjects.objPrivateAttributes != null &&
            objectWithNestedObjects.objWithObjects != null &&
            objectWithNestedObjects.objWithPrimitives != null
        );
        Assertions.assertTrue(attributesNotNull);
    }

}
