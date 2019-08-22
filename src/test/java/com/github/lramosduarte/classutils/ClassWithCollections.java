package com.github.lramosduarte.classutils;

import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
public class ClassWithCollections {

    List<String> atrList;

    Set<String> atrSet;

}
