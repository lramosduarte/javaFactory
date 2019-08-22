package com.github.lramosduarte.analyser;

import com.github.lramosduarte.data.Attribute;


public interface Analyser {

    <T> Iterable<Attribute> analyse(T cls) throws ClassNotFoundException;

}
