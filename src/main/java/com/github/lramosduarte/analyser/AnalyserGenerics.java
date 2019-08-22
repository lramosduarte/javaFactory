package com.github.lramosduarte.analyser;

import com.github.lramosduarte.data.TypesToGenerate;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public interface AnalyserGenerics {

    default List<TypesToGenerate> analyseParamsGenerics(ParameterizedType genericParms, int quantity) {
        Type[] types = genericParms.getActualTypeArguments();
        return Arrays.stream(types)
            .limit(Math.max(quantity, 1))
            .map(t -> (Class<?>) t)
            .map(TypesToGenerate::getEnum)
            .collect(Collectors.toList());
    }

}
