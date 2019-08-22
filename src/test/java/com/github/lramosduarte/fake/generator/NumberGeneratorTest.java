package com.github.lramosduarte.fake.generator;

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
        NumberGeneratorTest.generator.generate(1);
    }

    @Test
    public void testNumberGenerator_makeNumberBetweenOneAndSizeMultipleBySize() {
        int size = 1;
        Integer number = NumberGeneratorTest.generator.generate(size);
        boolean numberAreBetweenRange = number.intValue() >= 0 &&  number.intValue() <= (size * 10);
        Assertions.assertTrue(numberAreBetweenRange, () -> number.toString());
    }

}
