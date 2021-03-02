package com.timelord.simplykush.registry.item;

import com.timelord.simplykush.registry.ModItems;
import net.minecraft.item.Item;

public class Drug extends Item {
	public Drug (Settings settings) {
		super(settings);
	}
	
	private void addToItems(Item item){
		ModItems.registerItems(item);
	}
}
