package com.lramosduarte.fake;

import com.lramosduarte.classutils.ClassWithCollections;
import com.lramosduarte.classutils.ClassWithDictionarys;
import com.lramosduarte.classutils.SimpleClassAttributesPrimitives;
import com.lramosduarte.data.TypesToGenerate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorTest {

    private static FakeDataGenerator generator;

    @BeforeAll
    public static void setUpAll() {
        FakeDataGeneratorTest.generator = FakeDataGenerator.getInstance();
    }

    @Test
    public void testGeneratorFakeDataToPrimitiveBool_returnBoolPrimitive() {
        Assertions.assertEquals(
            Boolean.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(TypesToGenerate.BOOL).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToPrimitiveChar_returnChar() {
        Assertions.assertEquals(
            Character.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(TypesToGenerate.CHAR).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToSmallString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(TypesToGenerate.SMALL_TEXT).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToBigString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(TypesToGenerate.BIG_TEXT).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToNumber_returnNumber() {
        Assertions.assertEquals(
            Integer.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(TypesToGenerate.NUMBER).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToClass_returnNewInstanceOfClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object cls = FakeDataGeneratorTest.generator.make(SimpleClassAttributesPrimitives.class);
        Assertions.assertTrue(cls instanceof SimpleClassAttributesPrimitives);
    }

    @Test
    public void testGeneratorFakeDataToClassAttributes_returnNewInstanceOfClassWithData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        SimpleClassAttributesPrimitives simpleClass = FakeDataGeneratorTest.generator.make(SimpleClassAttributesPrimitives.class);
        Assertions.assertNotEquals(simpleClass.atrChar, new SimpleClassAttributesPrimitives().atrChar);
    }

    @Test
    public void testGeneratorFakeDataToClassWithCollectionsAttributes_returnNewInstanceOfClassWithData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassWithCollections object = FakeDataGeneratorTest.generator.make(ClassWithCollections.class);
        Assertions.assertNotNull(object.getAtrList());
    }

    @Test
    public void testGeneratorFakeDataToClassWithDictionaryAttributes_returnNewInstanceOfClassWithData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassWithDictionarys object = FakeDataGeneratorTest.generator.make(ClassWithDictionarys.class);
        Assertions.assertNotNull(object.getAtrDictionary());
    }

}
