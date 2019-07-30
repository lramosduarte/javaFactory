package com.lramosduarte.fake;


public interface Generator<TypeObject> {

    TypeObject generate(int len);

}
