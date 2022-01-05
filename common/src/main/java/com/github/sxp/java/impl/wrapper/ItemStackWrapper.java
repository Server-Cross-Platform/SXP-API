package com.github.sxp.java.impl.wrapper;

import com.github.sxp.java.api.minecraft.item.XItemStack;

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
}
