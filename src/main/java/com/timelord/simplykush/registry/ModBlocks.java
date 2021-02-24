package com.timelord.simplykush.registry;

import com.timelord.simplykush.SimplyKush;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CLAY_POT = new Block(FabricBlockSettings
            .of(Material.BAMBOO)
            .breakByHand(true)
            .strength(0.6F, 3)
            .sounds(BlockSoundGroup.STONE)
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(SimplyKush.MOD_ID, "clay_pot"), CLAY_POT);
    }
}
