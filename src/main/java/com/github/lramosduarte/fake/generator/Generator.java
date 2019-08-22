package com.github.lramosduarte.fake.generator;


public interface Generator<TypeObject> {

    TypeObject generate(int len);

}
