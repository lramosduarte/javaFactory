package com.github.lramosduarte.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class TypesToGenerateTest {

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassPrimitiveInt_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(int.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassPrimitiveShort_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(short.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassPrimitiveLong_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(long.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassPrimitiveFloat_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(float.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassPrimitiveDouble_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(double.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassNumberObjectJava_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(Number.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassObjectExtendNumber_returnTrue() {
        Assertions.assertTrue(TypesToGenerate.isNumber(Integer.class));
    }

    @Test
    public void testIdentifyIfVariableIsNumberWhenPassOtherType_returnFalse() {
        Assertions.assertFalse(TypesToGenerate.isNumber(String.class));
    }

    @Test
    public void testEnumReturnBoolWhenPassBooleanPrimitive_returnBoolEnum() {
        Assertions.assertEquals(
            TypesToGenerate.BOOL,
            TypesToGenerate.getEnum(boolean.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassBooleanObject_returnBoolEnum() {
        Assertions.assertEquals(
            TypesToGenerate.BOOL,
            TypesToGenerate.getEnum(Boolean.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassCharPrimitive_returnCharEnum() {
        Assertions.assertEquals(
            TypesToGenerate.CHAR,
            TypesToGenerate.getEnum(char.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassCharObject_returnCharEnum() {
        Assertions.assertEquals(
            TypesToGenerate.CHAR,
            TypesToGenerate.getEnum(Character.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassBytePrimitive_returnCharEnum() {
        Assertions.assertEquals(
            TypesToGenerate.CHAR,
            TypesToGenerate.getEnum(byte.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassCharPrimitive_returnNumberEnum() {
        Assertions.assertEquals(
            TypesToGenerate.NUMBER,
            TypesToGenerate.getEnum(int.class)
        );
    }

    @Test
    public void testEnumReturnBoolWhenPassCharObject_returnNumberEnum() {
        Assertions.assertEquals(
            TypesToGenerate.NUMBER,
            TypesToGenerate.getEnum(Number.class)
        );
    }

    @Test
    public void testPassToEnumComplexObject_returnObjectEnum() {
        class ClassTmp {}
        Assertions.assertEquals(
            TypesToGenerate.OBJECT,
            TypesToGenerate.getEnum(ClassTmp.class)
        );
    }

    @Test
    public void testPassListToEnum_returnCollectionEnum() {
        Assertions.assertEquals(
            TypesToGenerate.COLLECTION,
            TypesToGenerate.getEnum(List.class)
        );
    }

    @Test
    public void testPassSetToEnum_returnCollectionEnum() {
        Assertions.assertEquals(
            TypesToGenerate.COLLECTION,
            TypesToGenerate.getEnum(List.class)
        );
    }

    @Test
    public void testPassCollectionToEnum_returnCollectionEnum() {
        Assertions.assertEquals(
            TypesToGenerate.COLLECTION,
            TypesToGenerate.getEnum(List.class)
        );
    }

    @Test
    public void testPassMapToEnum_returnDictionaryEnum() {
        Assertions.assertEquals(
            TypesToGenerate.DICTIONARY,
            TypesToGenerate.getEnum(Map.class)
        );
    }

}
