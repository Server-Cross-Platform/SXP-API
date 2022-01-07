package com.github.sxp.platform.fabric.wrapper;

import com.github.sxp.java.impl.wrapper.ItemWrapper;
import net.minecraft.item.Item;

public class FabricItemWrapper implements ItemWrapper {
    protected final Item item;
    public FabricItemWrapper(Item item) {
        this.item = item;
    }
}
