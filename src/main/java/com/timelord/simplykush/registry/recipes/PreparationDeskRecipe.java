package com.timelord.simplykush.registry.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.timelord.simplykush.SimplyKush;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class PreparationDeskRecipe implements Recipe<Inventory> {
	public static final Codec<PreparationDeskRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			Registry.ITEM.fieldOf("inputA").forGetter(PreparationDeskRecipe::getInputA),
			Registry.ITEM.fieldOf("inputB").forGetter(PreparationDeskRecipe::getInputB),
			Registry.ITEM.fieldOf("inputC").forGetter(PreparationDeskRecipe::getInputC),
			Registry.ITEM.fieldOf("inputD").forGetter(PreparationDeskRecipe::getInputD),
			ItemStack.CODEC.fieldOf("result").forGetter(PreparationDeskRecipe::getOutput)
	).apply(instance, PreparationDeskRecipe::new));
	
	private final Identifier id = new Identifier("simplykush", "recipe");
	private final Item inputA;
	private final Item inputB;
	private final Item inputC;
	private final Item inputD;
	private final ItemStack outputStack;
	
	public PreparationDeskRecipe (Item inputA, Item inputB, Item inputC, Item inputD, ItemStack output) {
		
		this.inputA = inputA;
		this.inputB = inputB;
		this.inputC = inputC;
		this.inputD = inputD;
		this.outputStack = output;
	}
	
	public Item getInputA () {
		return this.inputA;
	}
	
	public Item getInputB () {
		return this.inputB;
	}
	
	public Item getInputC () {
		return inputC;
	}
	
	public Item getInputD () {
		return inputD;
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
	public RecipeSerializer<?> getSerializer () {
		return PreparationDeskRecipeSerializer.INSTANCE;
	}
	
	public ItemStack craft (Inventory inv) {
		return this.getOutput().copy();
	}
	
	@Override
	public boolean fits (int width, int height) {
		return width == 1 && height == 1;
	}
	
	@Override
	public boolean matches (Inventory inv, World world) {
		if (inv.size() < 2) return false;
		return this.inputA.equals(inv.getStack(0).getItem()) && this.inputB.equals(inv.getStack(1).getItem()) && this.inputC.equals(inv.getStack(2).getItem()) && this.inputD.equals(inv.getStack(3).getItem());
	}
	
	public static class Type implements RecipeType<PreparationDeskRecipe> {
		private Type () {
		}
		
		public static final Type INSTANCE = new Type();
		public static final String ID = "preparation_desk_recipe";
		
	}
	
	public RecipeType<? extends PreparationDeskRecipe> getType () {
		return SimplyKush.RECIPE_TYPE;
	}
	
}