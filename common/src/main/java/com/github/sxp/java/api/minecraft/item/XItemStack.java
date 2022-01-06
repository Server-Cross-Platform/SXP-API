package com.github.sxp.java.api.minecraft.item;

import com.github.sxp.java.api.minecraft.nbt.XNbt;
import com.github.sxp.java.api.minecraft.nbt.XTag;
import com.github.sxp.java.impl.error.InvalidItemStackException;
import com.github.sxp.java.impl.wrapper.ItemStackWrapper;


/**
 * An abrstraction of a Minecraft ItemStack
 **/
public class XItemStack implements ItemStackWrapper {
    ItemStackWrapper stack;
    public XItemStack(ItemStackWrapper stack) {
        if (stack instanceof XItemStack) throw new InvalidItemStackException();
        this.stack = stack;
    }

    @Override
    public XItemStack fromNbt(XNbt nbt) {
        return stack.fromNbt(nbt);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public XItemStack split(int amount) {
        return stack.split(amount);
    }

    @Override
    public int getMaxCount() {
        return stack.getCount();
    }

    @Override
    public boolean isStackable() {
        return stack.isStackable();
    }

    @Override
    public boolean isDamageable() {
        return stack.isDamageable();
    }

    @Override
    public boolean isDamaged() {
        return stack.isDamaged();
    }

    @Override
    public int getDamage() {
        return stack.getDamage();
    }

    @Override
    public void setDamage(int damage) {
        stack.setDamage(damage);
    }

    @Override
    public int getMaxDamage() {
        return stack.getMaxDamage();
    }

    @Override
    public int getCount() {
        return stack.getCount();
    }

    @Override
    public void setCount(int count) {
        stack.setCount(count);
    }

    @Override
    public boolean isIn(XTag<XItem> tag) {
        return stack.isIn(tag);
    }

    @Override
    public boolean isOf(XItem item) {
        return stack.isOf(item);
    }

    @Override
    public XNbt getNbt() {
        return stack.getNbt();
    }
}
