package com.BioStace.AutoTransfer.Item;

import com.BioStace.AutoTransfer.AutoTransfer;

import net.minecraft.item.Item;

public class ItemTransCart extends Item{
	public ItemTransCart()
	{
		this.setUnlocalizedName("TransCart");
		this.setTextureName(AutoTransfer.MODID+":TransCartNormal");
		this.setCreativeTab(AutoTransfer.autotransfer);
	}
}
