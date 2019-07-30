package com.lramosduarte.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StringGeneratorTest {

    private static StringGenerator generator;

    @BeforeAll
    public static void setUp() {
        StringGeneratorTest.generator = new StringGenerator();
    }

    @Test
    public void testStringGenerator_makeStringWithSuccess() {
        StringGeneratorTest.generator.generate(1);
    }

    @Test
    public void testStringGenerator_makeStringSameLengthPassByParameter() {
        int sizeString = 256;
        Assertions.assertEquals(
            sizeString,
            StringGeneratorTest.generator.generate(sizeString).length()
        );
    }

}
