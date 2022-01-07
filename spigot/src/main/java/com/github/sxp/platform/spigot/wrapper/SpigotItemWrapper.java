package com.github.sxp.platform.spigot.wrapper;

import com.github.sxp.java.impl.wrapper.ItemWrapper;
import net.minecraft.world.item.Item;

public class SpigotItemWrapper implements ItemWrapper {
    protected Item item;
    public SpigotItemWrapper(Item item) {
        this.item = item;
    }
}
