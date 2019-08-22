package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserImp;
import com.github.lramosduarte.data.Attribute;

import java.lang.reflect.InvocationTargetException;


/**
 * Define how each attribute of class will receive values
 */
public interface Setter {

    /**
     *
     * @param attribute attribute mapped by analyser
     * @param object instance or reference of attribute will receive values
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     *
     * @see AnalyserImp
     * @see Attribute
     */
    <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException;

}
