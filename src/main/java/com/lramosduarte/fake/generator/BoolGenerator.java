package com.lramosduarte.fake.generator;


public class BoolGenerator implements Generator<Boolean>{

    @Override
    public Boolean generate(int len) {
        return (Math.random() * 10 % 2) >= 1;
    }

}
