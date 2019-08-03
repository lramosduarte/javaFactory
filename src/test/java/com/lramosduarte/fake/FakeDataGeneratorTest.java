package com.lramosduarte.fake;

import com.lramosduarte.classutils.SimpleClassAttributesPrimitives;
import com.lramosduarte.data.TypesToGenerate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorTest {

    @Test
    public void testGeneratorFakeDataToPrimitiveBool_returnBoolPrimitive() {
        Assertions.assertEquals(
            Boolean.class.getSimpleName(),
            new FakeDataGenerator().make(TypesToGenerate.BOOL).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToPrimitiveChar_returnChar() {
        Assertions.assertEquals(
            Character.class.getSimpleName(),
            new FakeDataGenerator().make(TypesToGenerate.CHAR).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToSmallString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            new FakeDataGenerator().make(TypesToGenerate.SMALL_TEXT).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToBigString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            new FakeDataGenerator().make(TypesToGenerate.BIG_TEXT).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToNumber_returnNumber() {
        Assertions.assertEquals(
            Integer.class.getSimpleName(),
            new FakeDataGenerator().make(TypesToGenerate.NUMBER).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToClass_returnNewInstanceOfClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object cls = new FakeDataGenerator().make(SimpleClassAttributesPrimitives.class);
        Assertions.assertTrue(cls instanceof SimpleClassAttributesPrimitives);
    }

    @Test
    public void testGeneratorFakeDataToClassAttributes_returnNewInstanceOfClassWithData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        SimpleClassAttributesPrimitives simpleClass = new FakeDataGenerator().make(SimpleClassAttributesPrimitives.class);
        Assertions.assertNotEquals(simpleClass.atrChar, new SimpleClassAttributesPrimitives().atrChar);
    }

}
