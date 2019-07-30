package com.lramosduarte.fake;

import java.util.Random;


public class StringGenerator implements Generator<String>{
    private final int START_ALPHABET = 65;
    private final int END_ALPHABET = 90 + 1;

    StringGenerator() {}

    @Override
    public String generate(int len) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int asciiCode = new Random().ints(this.START_ALPHABET, this.END_ALPHABET).findFirst().getAsInt();
            data.append(Character.toChars(asciiCode));
        }
        return data.toString();
    }

}
