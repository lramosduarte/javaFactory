package com.lramosduarte.data;

import java.lang.reflect.Field;


public class Attribute {

    private Attribute() {}

    public String name;

    public TypesToGenerate type;

    public Field field;

    public static Attribute of(Field field) {
        Attribute attribute = new Attribute();
        attribute.field = field;
        attribute.name = field.getName();
        attribute.type = TypesToGenerate.getEnum(field.getType());
        return attribute;
    }

}
