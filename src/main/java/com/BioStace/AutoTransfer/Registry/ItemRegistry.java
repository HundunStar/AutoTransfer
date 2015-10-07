package com.BioStace.AutoTransfer.Registry;

import net.minecraft.item.Item;

import com.BioStace.AutoTransfer.Item.ItemTransCart;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {
	public static Item transcart;
	
	public static void init () {
		transcart = new ItemTransCart();
		registry();
	}
	
	public static void registry () {
		GameRegistry.registerItem(transcart, "TransCart");
	}
}
