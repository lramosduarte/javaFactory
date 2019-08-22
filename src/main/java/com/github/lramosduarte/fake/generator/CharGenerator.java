package com.github.lramosduarte.fake.generator;

import java.util.Random;


public class CharGenerator implements Generator<Character>{

    @Override
    public Character generate(int len) {
        byte[] byteChar = new byte[len];
        new Random().nextBytes(byteChar);
        return (char) byteChar[0];
    }

}
