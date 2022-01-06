package com.github.sxp.java.api.minecraft.nbt;

import com.github.sxp.java.impl.wrapper.NbtWrapper;

public class XNbt implements NbtWrapper {
    NbtWrapper nbt;
    public XNbt(NbtWrapper nbt) {
        this.nbt = nbt;
    }
}
