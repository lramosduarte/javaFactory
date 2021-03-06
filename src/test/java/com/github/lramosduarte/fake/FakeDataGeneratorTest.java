package com.github.lramosduarte.fake;

import com.github.lramosduarte.classutils.ClassDatetimeObjects;
import com.github.lramosduarte.classutils.SimpleClassAttributesPrimitives;
import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.classutils.ClassWithCollections;
import com.github.lramosduarte.classutils.ClassWithDictionarys;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.data.TypesToGenerate;
import com.github.lramosduarte.exception.GenerateValueException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import javax.validation.constraints.Size;


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
            FakeDataGeneratorTest.generator.make(Attribute.ofTypesToGenerate(TypesToGenerate.BOOL)).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToPrimitiveChar_returnChar() {
        Assertions.assertEquals(
            Character.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(Attribute.ofTypesToGenerate(TypesToGenerate.CHAR)).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToSmallString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(Attribute.ofTypesToGenerate(TypesToGenerate.SMALL_TEXT)).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToBigString_returnString() {
        Assertions.assertEquals(
            String.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(Attribute.ofTypesToGenerate(TypesToGenerate.BIG_TEXT)).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToNumber_returnNumber() {
        Assertions.assertEquals(
            Integer.class.getSimpleName(),
            FakeDataGeneratorTest.generator.make(Attribute.ofTypesToGenerate(TypesToGenerate.NUMBER)).getClass().getSimpleName()
        );
    }

    @Test
    public void testGeneratorFakeDataToStringWithCustomLengthFromSizeAnnotationJavax__returnStringWithDefaultLengthChanged()
            throws ClassNotFoundException {
        class ClassUsingJavaxAnnotations {
            @Size(min = 1, max = 10)
            String atrString;
        }
        Attribute attribute = AnalyserImp.getAnalyser().analyse(ClassUsingJavaxAnnotations.class).iterator().next();
        String stringWithCustomSize = FakeDataGeneratorTest.generator.make(attribute);
        Assertions.assertNotEquals(TypesToGenerate.SMALL_TEXT.size(), stringWithCustomSize.length());
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

    @Test
    public void makeAndIgnoreThrowsGenerateValueExceptionWhenClassIsAbstract() {
        Assertions.assertThrows(
            GenerateValueException.class,
            () -> FakeDataGenerator.getInstance().makeAndIgnore(WrapperClass.class, Collections.emptySet()));
    }

    @Test
    public void makeClassAllAtributesDateTime__returnAllAttributesWithValues() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassDatetimeObjects datetimeClass = FakeDataGeneratorTest.generator.make(ClassDatetimeObjects.class);
        boolean attributesNotNull = (
            datetimeClass.getAtrDayOfWeek() != null &&
            datetimeClass.getAtrLocalDate() != null &&
            datetimeClass.getAtrLocalDateTime() != null &&
            datetimeClass.getAtrZonedDateTime() != null &&
            datetimeClass.getAtrMonth() != null &&
            datetimeClass.getAtrLocalTime() != null
        );
        Assertions.assertTrue(attributesNotNull);
    }

    @Test
    public void fakeThrowsRuntimeErrorsForInstantiationException() {
        Assertions.assertThrows(
            RuntimeException.class,
            () -> FakeDataGenerator.fake(AbstractClass.class));
    }

    public static abstract class AbstractClass {}

    public static class WrapperClass {
        InnerPrivateClass field;

        public InnerPrivateClass getField() {
            return field;
        }

        public void setField(InnerPrivateClass field) {
            this.field = field;
        }
    }

    private class InnerPrivateClass {
        public InnerPrivateClass() {}
    }
}
