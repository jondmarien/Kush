package com.timelord.simplykush;

import com.timelord.simplykush.registry.ModBlocks;
import com.timelord.simplykush.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class SimplyKush implements ModInitializer {

    public static final String MOD_ID = "simplykush";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
