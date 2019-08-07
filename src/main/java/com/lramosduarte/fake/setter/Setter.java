package com.lramosduarte.fake.setter;

import com.lramosduarte.data.Attribute;

import java.lang.reflect.InvocationTargetException;


public interface Setter {

    <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException;

}
