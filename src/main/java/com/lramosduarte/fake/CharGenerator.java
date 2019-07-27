package com.lramosduarte.fake;

import java.util.Random;


public class CharGenerator implements Generator<Character>{

    CharGenerator() {}

    @Override
    public Character generateFakeData(int len) {
        byte[] byteChar = new byte[len];
        new Random().nextBytes(byteChar);
        return (char) byteChar[0];
    }

}
