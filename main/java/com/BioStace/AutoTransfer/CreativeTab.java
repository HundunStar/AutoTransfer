package com.BioStace.AutoTransfer;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	public CreativeTab() {
		super(AutoTransfer.MODID);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.rail);
	}
}
