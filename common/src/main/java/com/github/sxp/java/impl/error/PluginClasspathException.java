package com.github.sxp.java.impl.error;

public class PluginClasspathException extends RuntimeException {
    public PluginClasspathException(String jarname) {
        super("Invalid classpath in metadata for \""+jarname+"\"");
    }
}
