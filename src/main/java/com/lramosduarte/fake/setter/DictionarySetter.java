package com.lramosduarte.fake.setter;

import com.lramosduarte.analyser.AnalyserGenerics;
import com.lramosduarte.data.Attribute;
import com.lramosduarte.data.TypesToGenerate;
import com.lramosduarte.fake.FakeDataGenerator;

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
                this.fakeDataGenerator.make(typesParams.get(0)),
                this.fakeDataGenerator.make(typesParams.get(1))
            );
        }
        attribute.field.set(object, dictionary);
    }

}
