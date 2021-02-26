package com.timelord.simplykush.registry.recipes;

import com.google.gson.JsonObject;

public class PreparationDeskRecipeJsonFormat {
	JsonObject inputA;
	JsonObject inputB;
	String outputItem;
	int outputAmount;
	
	public JsonObject getInputA () {
		return inputA;
	}
	
	public void setInputA (JsonObject inputA) {
		this.inputA = inputA;
	}
	
	public JsonObject getInputB () {
		return inputB;
	}
	
	public void setInputB (JsonObject inputB) {
		this.inputB = inputB;
	}
	
	public String getOutputItem () {
		return outputItem;
	}
	
	public void setOutputItem (String outputItem) {
		this.outputItem = outputItem;
	}
	
	public int getOutputAmount () {
		return outputAmount;
	}
	
	public void setOutputAmount (int outputAmount) {
		this.outputAmount = outputAmount;
	}
	
}
