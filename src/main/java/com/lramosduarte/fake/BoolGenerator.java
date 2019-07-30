package com.lramosduarte.fake;


public class BoolGenerator implements Generator<Boolean>{

    BoolGenerator() {}

    @Override
    public Boolean generate(int len) {
        return (Math.random() * 10 % 2) >= 1;
    }

}
