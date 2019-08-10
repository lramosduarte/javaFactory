package com.lramosduarte.data;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


public enum TypesToGenerate {
    BOOL(1),
    NUMBER(4),
    CHAR(1),
    SMALL_TEXT(256),
    BIG_TEXT(4000),
    OBJECT(0),
    COLLECTION(1),
    DICTIONARY(1);

    private int size;

    TypesToGenerate(int size) {
        this.size = size;
    }

    public int size() {
        return this.size;
    }

    public static TypesToGenerate getEnum(Class<?> type) {
        if (type.isAssignableFrom(char.class) ||
            type.isAssignableFrom(byte.class) ||
            type.isAssignableFrom(Character.class)
        ) {
            return TypesToGenerate.CHAR;
        } else if(type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)) {
            return TypesToGenerate.BOOL;
        } else if (isNumber(type)) {
            return TypesToGenerate.NUMBER;
        } else if (type.isAssignableFrom(String.class)) {
            return TypesToGenerate.SMALL_TEXT;
        } else if (Collection.class.isAssignableFrom(type)) {
            return TypesToGenerate.COLLECTION;
        } else if (Map.class.isAssignableFrom(type)) {
            return TypesToGenerate.DICTIONARY;
        }
        return OBJECT;
    }

    public static boolean isNumber(Class<?> type) {
        final Set<String> intPrimitiveNumbers = Sets.newHashSet(
            int.class.getSimpleName(),
            short.class.getSimpleName(),
            long.class.getSimpleName(),
            double.class.getSimpleName(),
            float.class.getSimpleName()
        );
        if (intPrimitiveNumbers.contains(type.getSimpleName())) {
            return true;
        }
        try {
            type.asSubclass(Number.class);
        } catch (ClassCastException ex) {
            return false;
        }
        return true;
    }

    public static boolean isShort(Class<?> type) {
        return type.isAssignableFrom(short.class) || type.isAssignableFrom(Short.class);
    }

}
