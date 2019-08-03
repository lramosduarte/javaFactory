package com.lramosduarte.fake;

import com.lramosduarte.classutils.ClassUsingLombok;
import com.lramosduarte.classutils.ClassWithPrivateAttributesAndGetMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorPrivateAtributesAndMethodsGetTest {

    @Test
    public void testGenerateValuesObjectesPrivatesAttributes_returnInstanceWithSuccess() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassWithPrivateAttributesAndGetMethods instance = FakeDataGenerator.getInstance().make(ClassWithPrivateAttributesAndGetMethods.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    public void testNotGenerateValueToPrivateAttributeAndUseGetMethod_returnNull() {
        ClassWithPrivateAttributesAndGetMethods instance = new ClassWithPrivateAttributesAndGetMethods();
        Assertions.assertNull(instance.getAtrString());
    }


    @Test
    public void testGenerateValuesObjectesPrivatesAttributesUseGetMethod_returnValueGenerated() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassWithPrivateAttributesAndGetMethods instance = FakeDataGenerator.getInstance().make(ClassWithPrivateAttributesAndGetMethods.class);
        Assertions.assertNotNull(instance.getAtrString());
    }

    @Test
    public void testClassUsingLombokGenerateValuesObjectesPrivatesAttributes_returnInstanceWithSuccess() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassUsingLombok instance = FakeDataGenerator.getInstance().make(ClassUsingLombok.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    public void testClassUsingLombokNotGenerateValueToPrivateAttributeAndUseGetMethod_returnNull() {
        ClassUsingLombok instance = new ClassUsingLombok();
        Assertions.assertNull(instance.getAtrString());
    }


    @Test
    public void testClassUsingLombokGenerateValuesObjectesPrivatesAttributesUseGetMethod_returnValueGenerated() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassUsingLombok instance = FakeDataGenerator.getInstance().make(ClassUsingLombok.class);
        Assertions.assertNotNull(instance.getAtrString());
    }

}

