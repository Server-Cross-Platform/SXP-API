package com.github.sxp.platform.spigot.wrapper;

import com.github.sxp.java.api.minecraft.item.XItem;
import com.github.sxp.java.api.minecraft.item.XItemStack;
import com.github.sxp.java.api.minecraft.nbt.XNbt;
import com.github.sxp.java.impl.wrapper.ItemStackWrapper;
import net.minecraft.world.item.ItemStack;

public class SpigotItemStackWrapper implements ItemStackWrapper {
    protected final ItemStack stack;
    public SpigotItemStackWrapper(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public XItemStack split(int amount) {
        return new XItemStack(new SpigotItemStackWrapper(stack.split(amount)));
    }

    @Override
    public int getMaxCount() {
        return stack.getMaxStackSize();
    }

    @Override
    public boolean isStackable() {
        return stack.isStackable();
    }

    @Override
    public boolean isDamageable() {
        return stack.isDamageableItem();
    }

    @Override
    public boolean isDamaged() {
        return stack.isDamaged();
    }

    @Override
    public int getDamage() {
        return stack.getDamageValue();
    }

    @Override
    public void setDamage(int damage) {
        stack.setDamageValue(damage);
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
        SpigotItemWrapper wrapper = (SpigotItemWrapper) item.getItem();
        return stack.is(wrapper.item);
    }

    @Override
    public XNbt getNbt() {
        return new XNbt(new SpigotNbtWrapper(stack.getOrCreateTag()));
    }
}
