package com.timelord.simplykush.registry;

import com.mojang.serialization.JsonOps;
import com.timelord.simplykush.SimplyKush;
import com.timelord.simplykush.registry.recipes.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
	
	public static void registerRecipes(){
		ItemStack bagged_kush = new ItemStack(ModItems.BAGGED_KUSH, 1);
		PreparationDeskRecipe bagged_kush_recipe = new PreparationDeskRecipe(ModItems.PLASTIC_BAGGY, ModItems.SATIVA, ModItems.SCALE, ModItems.ROLLING_TRAY, bagged_kush);
		String json = PreparationDeskRecipe.CODEC.encodeStart(JsonOps.INSTANCE, bagged_kush_recipe).getOrThrow(false, System.err::println).toString();
		System.out.println(json);
		
		Registry.register(Registry.RECIPE_SERIALIZER, PreparationDeskRecipe.Type.ID, PreparationDeskRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier(SimplyKush.MOD_ID, PreparationDeskRecipe.Type.ID), PreparationDeskRecipe.Type.INSTANCE);
	}
}
