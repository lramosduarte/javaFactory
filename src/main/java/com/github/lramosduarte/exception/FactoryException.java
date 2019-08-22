package com.github.lramosduarte.exception;


public abstract class FactoryException extends RuntimeException {

    public FactoryException(Exception ex) {
        ex.printStackTrace();
    }

}
