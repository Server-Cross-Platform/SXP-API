package com.github.sxp.java.api.minecraft.item;

import com.github.sxp.java.impl.wrapper.ItemStackWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.text.Text;

public class XItemStack extends ItemStackWrapper {
    public XItemStack(ItemStack stack) {
        super(stack);
    }

    /**
     * Gets the item's lore
     * @return The lore of the item
     **/
    public NbtList getLore() {
        NbtCompound nbt = this.getNbt();
        NbtCompound display = new NbtCompound();
        if (nbt.contains("display"))
            display = nbt.getCompound("display");
        if (display.contains("Lore")) return display.getList("Lore",8);
        return new NbtList();
    }

    /**
     * Sets the lore of the item
     * @param lore The lore to set
     **/
    public void setLore(NbtList lore) {
        NbtCompound nbt = this.getNbt();
        NbtCompound display = new NbtCompound();
        if (nbt.contains("display"))
            display = nbt.getCompound("display");
        display.put("Lore",lore);
        nbt.put("display",display);
    }

    /**
     * Appends a line of lore to the item
     * @param lore The line to add
     **/
    public void addLoreLine(Text lore) {
        NbtList list = getLore();
        list.add(NbtString.of(Text.Serializer.toJson(lore)));
        setLore(list);
    }

    /**
     * Sets a line of lore
     * @param line The line number to change
     * @param lore The lore to set
     **/
    public void setLoreLine(int line, Text lore) {
        NbtList list = getLore();
        list.add(line, NbtString.of(Text.Serializer.toJson(lore)));
        setLore(list);
    }

    /**
     * Gets a line of lore
     * @param line The line to get
     * @return The line of lore
     **/
    public Text getLoreLine(int line) {
        NbtList list = getLore();
        return Text.Serializer.fromJson(list.get(line).asString());
    }
}
