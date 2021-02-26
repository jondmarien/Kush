package com.timelord.simplykush.registry.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sun.xml.internal.ws.server.AbstractMultiInstanceResolver;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class PreparationDeskRecipe implements Recipe<CraftingInventory> {

	
	private final Ingredient inputA;
	private final Ingredient inputB;
	private final ItemStack outputStack;
	private final Identifier id;
	
	public PreparationDeskRecipe (Ingredient inputA, Ingredient inputB, ItemStack output, Identifier id) {
		this.id = id;
		this.inputA = inputA;
		this.inputB = inputB;
		this.outputStack = output;
	}
	
	public Ingredient getInputA () {
		return this.inputA;
	}
	
	public Ingredient getInputB () {
		return this.inputB;
	}
	
	@Override
	public ItemStack getOutput () {
		return this.outputStack;
	}
	
	@Override
	public Identifier getId () {
		return this.id;
	}
	
	@Override
	public DefaultedList<ItemStack> getRemainingStacks (CraftingInventory inv) {
		return Recipe.super.getRemainingStacks(inv);
	}
	
	@Override
	public RecipeSerializer<?> getSerializer () {
		return PreparationDeskRecipeSerializer.INSTANCE;
	}
	
	@Override
	public boolean fits (int width, int height) {
		return false;
	}
	
	@Override
	public boolean matches (CraftingInventory inv, World world) {
		if (inv.size() < 2) return false;
		return inputA.test(inv.getStack(0)) && inputB.test(inv.getStack(1));
	}
	
	public ItemStack craft (CraftingInventory inv) {
		return this.getOutput().copy();
	}
	
	public static class Type implements RecipeType<PreparationDeskRecipe> {
		private Type () {
		}
		
		public static final Type INSTANCE = new Type();
		public static final String ID = "preparation_desk_recipe";
		
	}
	
	public RecipeType<?> getType () {
		return Type.INSTANCE;
	}
	
}