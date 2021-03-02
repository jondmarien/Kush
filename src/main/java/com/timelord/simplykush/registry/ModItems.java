package com.timelord.simplykush.registry;

import com.timelord.simplykush.SimplyKush;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    /**
     * Items
     */
    public static final Item SATIVA = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final Item INDICA = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final Item ROLLING_TRAY = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final Item SCALE = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final Item PLASTIC_BAGGY = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final Item BAGGED_KUSH = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));

    /**
     * Seeds
     */
    public static final Item SEEDS = new Item(new Item.Settings().group(SimplyKush.SIMPLY_KUSH));

    /**
     * Block Items
     */
    public static final BlockItem CLAY_POT = new BlockItem(ModBlocks.CLAY_POT, new Item.Settings().group(SimplyKush.SIMPLY_KUSH));
    public static final BlockItem PREPARATION_DESK = new BlockItem(ModBlocks.PREPARATION_DESK, new Item.Settings().group(SimplyKush.SIMPLY_KUSH));

    public static void registerItems() {
        // Items
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "sativa"), SATIVA);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "indica"), INDICA);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "rolling_tray"), ROLLING_TRAY);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "scale"), SCALE);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "plastic_baggy"), PLASTIC_BAGGY);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "bagged_kush"), BAGGED_KUSH);

        // Seeds
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "seeds"), SEEDS);

        // Block Items
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "clay_pot"), CLAY_POT);
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "preparation_desk"), PREPARATION_DESK);
    }
    
    public static void registerItems(Item skitem) {
        Registry.register(Registry.ITEM, new Identifier(SimplyKush.MOD_ID, "skitem"), skitem);
    }
}
