package com.lramosduarte.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class NumberGeneratorTest {

    private static NumberGenerator generator;

    @BeforeAll
    public static void setUp() {
        NumberGeneratorTest.generator = new NumberGenerator();
    }

    @Test
    public void testNumberGenerator_makeNumberWithSuccess() {
        NumberGeneratorTest.generator.generateFakeData(1);
    }

    @Test
    public void testNumberGenerator_makeNumberBetweenOneAndSizeMultipleBySize() {
        int size = 1;
        Integer number = NumberGeneratorTest.generator.generateFakeData(size);
        boolean numberAreBetweenRange = number.intValue() >= 1 &&  number.intValue() <= (size * 10);
        Assertions.assertTrue(numberAreBetweenRange);
    }

}
