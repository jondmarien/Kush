package com.timelord.simplykush.registry;

import com.timelord.simplykush.SimplyKush;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item SATIVA = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item INDICA = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "sativa"), SATIVA);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "indica"), INDICA);
    }
}
