package com.lramosduarte.fake;

import com.lramosduarte.classutils.ClassWithPrivateAttributesAndGetMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorPrivateAtributesAndMethodsGetTest {

    @Test
    public void testGenerateValuesObjectesPrivatesAttributes_returnInstanceWithSuccess() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassWithPrivateAttributesAndGetMethods instance = new FakeDataGenerator().make(ClassWithPrivateAttributesAndGetMethods.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    public void testNotGenerateValueToPrivateAttributeAndUseGetMethod_returnNull() {
        ClassWithPrivateAttributesAndGetMethods instance = new ClassWithPrivateAttributesAndGetMethods();
        Assertions.assertNull(instance.getAtrString());
    }


    @Test
    public void testGenerateValuesObjectesPrivatesAttributesUseGetMethod_returnValueGenerated() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassWithPrivateAttributesAndGetMethods instance = new FakeDataGenerator().make(ClassWithPrivateAttributesAndGetMethods.class);
        Assertions.assertNotNull(instance.getAtrString());
    }

}

