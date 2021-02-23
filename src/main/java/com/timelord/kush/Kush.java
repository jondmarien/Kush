package com.timelord.kush;

import com.timelord.kush.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Kush implements ModInitializer {

    public static final String MOD_ID = "kush";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
