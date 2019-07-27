package com.lramosduarte.fake;


public class BoolGenerator implements Generator<Boolean>{

    BoolGenerator() {}

    @Override
    public Boolean generateFakeData(int len) {
        return (Math.random() % 2) == 1;
    }

}
