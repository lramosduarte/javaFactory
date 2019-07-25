package com.lramosduarte.analyser;

import com.lramosduarte.data.Attribute;


public interface Analyser {

    <T> Iterable<Attribute> analyse(T cls) throws ClassNotFoundException;

}
