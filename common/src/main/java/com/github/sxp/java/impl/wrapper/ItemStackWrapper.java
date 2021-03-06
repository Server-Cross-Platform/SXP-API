package com.github.sxp.java.impl.wrapper;

import com.github.sxp.java.api.minecraft.item.XItem;
import com.github.sxp.java.api.minecraft.item.XItemStack;
import com.github.sxp.java.api.minecraft.nbt.XNbt;

public interface ItemStackWrapper {

    boolean isEmpty();

    XItemStack split(int amount);

    int getMaxCount();

    boolean isStackable();

    boolean isDamageable();

    boolean isDamaged();

    int getDamage();

    void setDamage(int damage);

    int getMaxDamage();

    int getCount();

    void setCount(int count);

    boolean isOf(XItem item);

    XNbt getNbt();
}
