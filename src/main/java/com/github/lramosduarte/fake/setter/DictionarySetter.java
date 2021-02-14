package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserGenerics;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.data.TypesToGenerate;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DictionarySetter implements Setter, AnalyserGenerics {

    private final int QUANTITY_TO_KEY_AND_VALUE = 2;

    private final FakeDataGenerator fakeDataGenerator;

    public DictionarySetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        attribute.field.setAccessible(true);
        Map dictionary = new HashMap();
        List<TypesToGenerate> typesParams =
            this.analyseParamsGenerics((ParameterizedType) attribute.field.getGenericType(), this.QUANTITY_TO_KEY_AND_VALUE);
        for (int i = 0; i < attribute.type.size(); i++) {
            dictionary.put(
                this.fakeDataGenerator.make(Attribute.ofTypesToGenerate(typesParams.get(0))),
                this.fakeDataGenerator.make(Attribute.ofTypesToGenerate(typesParams.get(1)))
            );
        }
        attribute.field.set(object, dictionary);
    }

}
