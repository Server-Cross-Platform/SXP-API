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

    public NbtList getLore() {
        NbtCompound nbt = this.getNbt();
        NbtCompound display = new NbtCompound();
        if (nbt.contains("display"))
            display = nbt.getCompound("display");
        if (display.contains("Lore")) return display.getList("Lore",8);
        return new NbtList();
    }

    public void setLore(NbtList lore) {
        NbtCompound nbt = this.getNbt();
        NbtCompound display = new NbtCompound();
        if (nbt.contains("display"))
            display = nbt.getCompound("display");
        display.put("Lore",lore);
        nbt.put("display",display);
    }

    public void addLoreLine(Text lore) {
        NbtList list = getLore();
        list.add(NbtString.of(Text.Serializer.toJson(lore)));
        setLore(list);
    }

    public void setLoreLine(int line, Text lore) {
        NbtList list = getLore();
        list.add(line, NbtString.of(Text.Serializer.toJson(lore)));
        setLore(list);
    }

    public Text getLoreLine(int line) {
        NbtList list = getLore();
        return Text.Serializer.fromJson(list.get(line).asString());
    }
}
