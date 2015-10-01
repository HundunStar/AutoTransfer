package com.BioStace.AutoTransfer;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ATCreativeTab extends CreativeTabs{

	public ATCreativeTab() {
		super("AutoTransfer");
	}

	@Override
	public Item getTabIconItem() {
		return ItemBlock.getItemFromBlock(Blocks.rail);
	}

}
