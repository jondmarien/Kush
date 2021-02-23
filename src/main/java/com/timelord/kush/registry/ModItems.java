package com.timelord.kush.registry;

import com.timelord.kush.Kush;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item BUD = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(Kush.MOD_ID, "bud"), BUD);
    }
}
