package com.github.sxp.platform.spigot.wrapper;

import com.github.sxp.java.impl.wrapper.NbtWrapper;
import net.minecraft.nbt.NBTTagCompound;

public class SpigotNbtWrapper implements NbtWrapper {
    protected final NBTTagCompound nbt;
    public SpigotNbtWrapper(NBTTagCompound nbt) {
        this.nbt = nbt;
    }
}
