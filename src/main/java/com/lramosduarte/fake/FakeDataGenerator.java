package com.lramosduarte.fake;

import com.google.common.collect.ImmutableMap;
import com.lramosduarte.data.TypesToGenerate;


public class FakeDataGenerator {

    private ImmutableMap<TypesToGenerate, Generator> MAP_GENERATOR = ImmutableMap.of(
        TypesToGenerate.BOOL, new BoolGenerator(),
        TypesToGenerate.CHAR, new CharGenerator(),
        TypesToGenerate.SMALL_TEXT, new StringGenerator(),
        TypesToGenerate.BIG_TEXT, new StringGenerator(),
        TypesToGenerate.NUMBER, new NumberGenerator()
    );

    public <TypeObject> TypeObject make(TypesToGenerate type) {
        return (TypeObject) this.MAP_GENERATOR.get(type).generateFakeData(type.size());
    }

}
