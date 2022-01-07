package com.github.sxp.java.api.minecraft.item;

import com.github.sxp.java.impl.error.InvalidItemException;
import com.github.sxp.java.impl.wrapper.ItemWrapper;

public class XItem implements ItemWrapper {
    ItemWrapper item;
    public XItem(ItemWrapper item) {
        if (item instanceof XItem) throw new InvalidItemException();
        this.item = item;
    }

    public ItemWrapper getItem() {
        return item;
    }
}
