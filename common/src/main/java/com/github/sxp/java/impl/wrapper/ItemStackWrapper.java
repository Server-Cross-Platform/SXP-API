package com.github.sxp.java.impl.wrapper;

import com.github.sxp.java.api.item.XItemStack;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ItemStackWrapper {
    private final ItemStack itemStack;

    public ItemStackWrapper(ItemStack stack) {
        itemStack = stack;
    }

    protected ItemStack getItemStack() {
        return itemStack;
    }

    public Item getItem() {
        return itemStack.getItem();
    }

    public static XItemStack fromNbt(NbtCompound nbt) {
        return new XItemStack(ItemStack.fromNbt(nbt));
    }

    public Optional<TooltipData> getTooltipData() {
        return itemStack.getTooltipData();
    }

    public boolean isEmpty() {
        return itemStack.isEmpty();
    }

    public XItemStack split(int amount) {
        return new XItemStack(itemStack.split(amount));
    }

    public boolean isIn(Tag<Item> tag) {
        return itemStack.isIn(tag);
    }

    public boolean isOf(Item item) {
        return  itemStack.isOf(item);
    }

    public float getMiningSpeedMultiplier(BlockState state) {
        return itemStack.getMiningSpeedMultiplier(state);
    }

    public NbtCompound getNbt() {
        return itemStack.getOrCreateNbt();
    }

    public void setNbt(NbtCompound nbt) {
        itemStack.setNbt(nbt);
    }

    public int getMaxCount() {
        return itemStack.getMaxCount();
    }

    public boolean isStackable() {
        return itemStack.isStackable();
    }

    public boolean isDamageable() {
        return itemStack.isDamageable();
    }

    public boolean isDamaged() {
        return itemStack.isDamaged();
    }

    public int getDamage() {
        return itemStack.getDamage();
    }

    public void setDamage(int damage) {
        itemStack.setDamage(damage);
    }

    public int getMaxDamage() {
        return itemStack.getMaxDamage();
    }

    public NbtList getEnchantments() {
        return itemStack.getEnchantments();
    }

    public Text getName() {
        return itemStack.getName();
    }

    public void setName(Text name) {
        itemStack.setCustomName(name);
    }

    public void removeName() {
        itemStack.removeCustomName();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return itemStack.getAttributeModifiers(slot);
    }

    public void addAttributeModifier(EntityAttribute attribute, EntityAttributeModifier modifier, @Nullable EquipmentSlot slot) {
        itemStack.addAttributeModifier(attribute,modifier,slot);
    }

    public int getCount() {
        return itemStack.getCount();
    }

    public void setCount(int count) {
        itemStack.setCount(count);
    }


}
