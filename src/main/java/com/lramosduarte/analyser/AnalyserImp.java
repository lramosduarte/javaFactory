package com.lramosduarte.analyser;

import com.lramosduarte.data.Attribute;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AnalyserImp implements Analyser {

    @Override
    public <T> Iterable<Attribute> analyse(T cls) throws ClassNotFoundException {
        Field[] attributes = Class.forName(((Class) cls).getName()).getDeclaredFields();
        return Stream.of(attributes).map(Attribute::of).collect(Collectors.toList());
    }

}
