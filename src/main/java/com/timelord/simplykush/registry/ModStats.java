package com.timelord.simplykush.registry;

import com.timelord.simplykush.SimplyKush;
import net.minecraft.stat.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStats {
	
	public static final Identifier INTERACT_WITH_PREPARATION_DESK = new Identifier(SimplyKush.MOD_ID,"interact_with_preparation_desk");
	
	public static void registerStats(){
		Registry.register(Registry.CUSTOM_STAT, "interact_with_preparation_desk", INTERACT_WITH_PREPARATION_DESK);
		
		Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_PREPARATION_DESK, StatFormatter.DEFAULT);
	}
}
