package com.lramosduarte.data;

import java.lang.reflect.Field;


public class Attribute {

    public String name;

    public String type;

    public Field field;

    public static Attribute of(Field field) {
        Attribute attribute = new Attribute();
        attribute.field = field;
        attribute.name = field.getName();
        attribute.type = field.getType().getName();
        return attribute;
    }

}
