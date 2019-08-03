package com.lramosduarte.fake.generator;


public interface Generator<TypeObject> {

    TypeObject generate(int len);

}
