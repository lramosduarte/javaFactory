package com.github.lramosduarte.fake.generator;

import java.util.Random;


public class NumberGenerator implements Generator<Integer>{

    @Override
    public Integer generate(int len) {
        return new Random().ints(0, len * 10).findFirst().getAsInt();
    }
}
