package com.timelord.simplykush.registry.recipes;

import com.google.gson.*;
import net.minecraft.item.*;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PreparationDeskRecipeSerializer implements RecipeSerializer<PreparationDeskRecipe> {
	
	public static final PreparationDeskRecipeSerializer INSTANCE = new PreparationDeskRecipeSerializer();
	
	// "type" field in json file
	public static final Identifier ID = new Identifier("simplykush:preparation_desk_recipe");
	
	private PreparationDeskRecipeSerializer () {
	}
	
	@Override
	// Turns json into Recipe
	public PreparationDeskRecipe read (Identifier recipeID, JsonObject json) {
		PreparationDeskRecipeJsonFormat recipeJsonFormat = new Gson().fromJson(json, PreparationDeskRecipeJsonFormat.class);
		
		// Validation of fields
		if (recipeJsonFormat.inputA == null || recipeJsonFormat.inputB == null || recipeJsonFormat.outputItem == null) {
			throw new JsonSyntaxException("A required attribute is missing!");
		}
		// Not specifying the output item is allowed, default is 1.
		if (recipeJsonFormat.outputAmount == 0) recipeJsonFormat.outputAmount = 1;
		
		Ingredient inputA = Ingredient.fromJson(recipeJsonFormat.inputA);
		Ingredient inputB = Ingredient.fromJson(recipeJsonFormat.inputB);
		Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJsonFormat.outputItem))
				.orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJsonFormat.outputItem));
		ItemStack outputStack = new ItemStack(outputItem, recipeJsonFormat.outputAmount);
		
		return new PreparationDeskRecipe(inputA, inputB, outputStack, recipeID);
	}
	
	@Override
	// Turns Recipe into PacketByteBuf
	public PreparationDeskRecipe read (Identifier recipeID, PacketByteBuf packetData) {
		
		Ingredient inputA = Ingredient.fromPacket(packetData);
		Ingredient inputB = Ingredient.fromPacket(packetData);
		ItemStack outputStack = packetData.readItemStack();
		
		return new PreparationDeskRecipe(inputA, inputB, outputStack, recipeID);
	}
	
	@Override
	// Turns PacketByteBuf into Recipe
	public void write (PacketByteBuf packetData, PreparationDeskRecipe recipe) {
		recipe.getInputA().write(packetData);
		recipe.getInputB().write(packetData);
		packetData.writeItemStack(recipe.getOutput());
	}
}
