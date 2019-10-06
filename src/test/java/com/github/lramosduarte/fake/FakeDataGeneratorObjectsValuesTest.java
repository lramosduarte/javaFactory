package com.github.lramosduarte.fake;

import com.github.lramosduarte.classutils.SimpleClassAttributesObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorObjectsValuesTest {

    @Test
    public void testGenerateValuesObjectes_returnInstanceWithSuccess() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        SimpleClassAttributesObjects instance = FakeDataGenerator.getInstance().make(SimpleClassAttributesObjects.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    public void testInstanceWithoutGenerateValues_returnAttributesNull() {
        SimpleClassAttributesObjects instance = new SimpleClassAttributesObjects();
        Assertions.assertNull(instance.atrBigDecimal);
    }

    @Test
    public void testGenerateValuesObjects_returnAttributesNotNull() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        SimpleClassAttributesObjects instance = FakeDataGenerator.getInstance().make(SimpleClassAttributesObjects.class);
        Assertions.assertNotNull(instance.atrBigDecimal);
    }

}

