package com.lramosduarte.data;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public enum TypesToGenerate {
    BOOL(1),
    NUMBER(Integer.MAX_VALUE),
    DECIMAL(Integer.MAX_VALUE),
    CHAR(1),
    SMALL_TEXT(256),
    BIG_TEXT(4000);

    private int size;

    TypesToGenerate(int size) {
        this.size = size;
    }

    public int size() {
        return this.size;
    }

    public static TypesToGenerate getEnum(String name) {
        if (name.equals("char")) {
            return TypesToGenerate.CHAR;
        } else if(name.equals("boolean")) {
            return TypesToGenerate.BOOL;
        }
        throw new NotImplementedException();
    }

}
