package com.BioStace.AutoTransfer;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ATCreativeTab extends CreativeTabs{

	public ATCreativeTab() {
		super("AutoTransfer");
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Item getTabIconItem() {
		// TODO 自动生成的方法存根
		return ItemBlock.getItemFromBlock(Blocks.rail);
	}

}
