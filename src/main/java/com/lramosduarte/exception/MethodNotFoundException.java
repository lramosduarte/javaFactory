package com.lramosduarte.exception;


public class MethodNotFoundException extends FactoryException {

    public MethodNotFoundException(Exception ex) {
        super(ex);
    }

}
