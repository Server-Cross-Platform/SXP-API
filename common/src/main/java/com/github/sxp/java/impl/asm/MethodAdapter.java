package com.github.sxp.java.impl.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodAdapter extends ClassVisitor {
    public ClassVisitor cv;
    public MethodAdapter(ClassVisitor cv) {
        super(Opcodes.ASM9, cv);
        this.cv = cv;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
