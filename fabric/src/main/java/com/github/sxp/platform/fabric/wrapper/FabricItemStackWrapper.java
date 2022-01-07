package com.github.sxp.platform.fabric.wrapper;

import com.github.sxp.java.api.minecraft.item.XItem;
import com.github.sxp.java.api.minecraft.item.XItemStack;
import com.github.sxp.java.api.minecraft.nbt.XNbt;
import com.github.sxp.java.impl.wrapper.ItemStackWrapper;
import net.minecraft.item.ItemStack;

public class FabricItemStackWrapper implements ItemStackWrapper {
    protected final ItemStack stack;

    public FabricItemStackWrapper(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public XItemStack split(int amount) {
        return new XItemStack(new FabricItemStackWrapper(stack.split(amount)));
    }

    @Override
    public int getMaxCount() {
        return stack.getMaxCount();
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
    public boolean isOf(XItem item) {
        FabricItemWrapper wrapper = (FabricItemWrapper)item.getItem();
        return stack.isOf(wrapper.item);
    }

    @Override
    public XNbt getNbt() {
        return new XNbt(new FabricNbtWrapper(stack.getOrCreateNbt()));
    }
}
