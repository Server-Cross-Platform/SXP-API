package com.github.sxp.java.impl.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class XClassWriter {
    String className;
    String cloneableInterface = "java/lang/Cloneable";
    ClassReader reader;
    ClassWriter writer;

    public XClassWriter(String className) throws IOException {
        this.className = className;
        reader = new ClassReader(className);
        writer = new ClassWriter(reader, 0);

    }
}
