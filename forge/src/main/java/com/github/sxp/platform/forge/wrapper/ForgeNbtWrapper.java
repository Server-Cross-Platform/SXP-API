package com.github.sxp.platform.forge.wrapper;

import com.github.sxp.java.impl.wrapper.NbtWrapper;
import net.minecraft.nbt.NbtCompound;

public class ForgeNbtWrapper implements NbtWrapper {
    protected final NbtCompound nbt;
    public ForgeNbtWrapper(NbtCompound nbt) {
        this.nbt = nbt;
    }
}
