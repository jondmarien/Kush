package com.timelord.simplykush;

import com.timelord.simplykush.registry.ModBlocks;
import com.timelord.simplykush.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.lwjgl.system.CallbackI;

public class SimplyKush implements ModInitializer {

    public static final String MOD_ID = "simplykush";

    public static final ItemGroup SIMPLY_KUSH = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.INDICA)
    );

    public static final ItemGroup TEST = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "test"))
            .icon(() -> new ItemStack(Blocks.ENCHANTING_TABLE))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(ModBlocks.CLAY_POT));
                itemStacks.add(new ItemStack(ModItems.SATIVA));
                itemStacks.add(new ItemStack(ModItems.INDICA));
            })
            .build();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
