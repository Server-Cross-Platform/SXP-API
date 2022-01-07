package com.github.sxp.java.platform.fabric.wrapper;

import com.github.sxp.java.impl.wrapper.NbtWrapper;
import net.minecraft.nbt.NbtCompound;

public class FabricNbtWrapper implements NbtWrapper {
    protected final NbtCompound nbt;
    public FabricNbtWrapper(NbtCompound nbt) {
        this.nbt = nbt;
    }
}
