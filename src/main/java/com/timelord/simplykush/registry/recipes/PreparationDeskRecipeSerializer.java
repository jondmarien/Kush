package com.timelord.simplykush.registry.recipes;

import com.google.gson.*;
import com.mojang.serialization.JsonOps;
import net.minecraft.item.*;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PreparationDeskRecipeSerializer implements RecipeSerializer<PreparationDeskRecipe> {
	
	public static final PreparationDeskRecipeSerializer INSTANCE = new PreparationDeskRecipeSerializer();
	
	@Override
	// Turns json into Recipe
	public PreparationDeskRecipe read (Identifier recipeID, JsonObject json) {
		return PreparationDeskRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
	}
	
	@Override
	// Turns Recipe into PacketByteBuf
	public PreparationDeskRecipe read (Identifier recipeID, PacketByteBuf packetData) {
		
		Item inputA = Registry.ITEM.get(packetData.readIdentifier());
		Item inputB = Registry.ITEM.get(packetData.readIdentifier());
		Item inputC = Registry.ITEM.get(packetData.readIdentifier());
		Item inputD = Registry.ITEM.get(packetData.readIdentifier());
		ItemStack outputStack = packetData.readItemStack();
		
		return new PreparationDeskRecipe(inputA, inputB, inputC, inputD, outputStack);
	}
	
	@Override
	// Turns PacketByteBuf into Recipe
	public void write (PacketByteBuf packetData, PreparationDeskRecipe recipe) {
		packetData.writeIdentifier(Registry.ITEM.getId(recipe.getInputA()));
		packetData.writeIdentifier(Registry.ITEM.getId(recipe.getInputB()));
		packetData.writeIdentifier(Registry.ITEM.getId(recipe.getInputC()));
		packetData.writeIdentifier(Registry.ITEM.getId(recipe.getInputD()));
		packetData.writeItemStack(recipe.getOutput());
	}
}
