package com.github.lramosduarte.data;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.validation.constraints.Size;


public class Attribute {

    private Attribute() {}

    public String name;

    public TypesToGenerate type;

    public Field field;

    private int size;

    public static Attribute of(Field field) {
        Attribute attribute = new Attribute();
        attribute.field = field;
        attribute.name = field.getName();
        attribute.type = TypesToGenerate.getEnum(field.getType());
        return attribute;
    }

    public static Attribute ofTypesToGenerate(TypesToGenerate type) {
        Attribute attribute = new Attribute();
        attribute.type = type;
        return attribute;
    }

    public Integer getLenght() {
        this.size = this.type.size();
        if (this.field != null) {
            Arrays.stream(this.field.getDeclaredAnnotations())
                .filter(a -> a instanceof Size)
                .findFirst()
                .ifPresent(annotation -> this.size = ((Size) annotation).max());
        }
        return this.size;
    }

}
