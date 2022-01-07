package com.github.sxp.java.impl.error;

public class InvalidItemException extends RuntimeException {
    public InvalidItemException() {
        super("Unable to create Item, passed XItem into constructor.");
    }
}
