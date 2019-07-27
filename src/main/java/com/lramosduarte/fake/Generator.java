package com.lramosduarte.fake;


public interface Generator<TypeObject> {

    TypeObject generateFakeData(int len);

}
