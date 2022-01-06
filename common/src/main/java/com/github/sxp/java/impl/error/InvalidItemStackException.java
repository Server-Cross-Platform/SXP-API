package com.github.sxp.java.impl.error;

public class InvalidItemStackException extends RuntimeException {
    public InvalidItemStackException() {
        super("Unable to create ItemStack, passed XItemStack into contructor.");
    }
}
