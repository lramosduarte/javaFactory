package com.lramosduarte.fake;

import com.lramosduarte.SimpleClassAttributesObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FakeDataGeneratorObjectsValuesTest {

    @Test
    public void testGenerateValuesObjectes_returnInstanceWithSuccess() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        SimpleClassAttributesObjects instance = new FakeDataGenerator().make(SimpleClassAttributesObjects.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    public void testInstanceWIthoutGenerateValues_returnAttributesNull() {
        SimpleClassAttributesObjects instance = new SimpleClassAttributesObjects();
        Assertions.assertNull(instance.atrBigDecimal);
    }

    @Test
    public void testGenerateValuesObjectes_returnAttributesNotNull() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        SimpleClassAttributesObjects instance = new FakeDataGenerator().make(SimpleClassAttributesObjects.class);
        Assertions.assertNotNull(instance.atrBigDecimal);
    }

}

