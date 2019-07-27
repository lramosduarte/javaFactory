package com.lramosduarte.fake;

import java.util.Random;


public class NumberGenerator implements Generator<Integer>{

    NumberGenerator() {}

    @Override
    public Integer generateFakeData(int len) {
        return new Random().ints(0, len * 10).findFirst().getAsInt();
    }
}
