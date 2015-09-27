package com.BioStace.AutoTransfer.Block;

import com.BioStace.AutoTransfer.AutoTransfer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTransOrbit extends Block{

	public BlockTransOrbit(Material m) {
		super(m);
		// TODO 自动生成的构造函数存根
		this.setBlockName("TransferOrbit");
		this.setBlockTextureName(AutoTransfer.MODID+":TransferOrbit");
		this.setHardness(0.5f);
		this.setResistance(10.0f);
		this.setLightLevel(1.0f);
		this.setCreativeTab(AutoTransfer.ATCreative);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeMetal);
	}

}
