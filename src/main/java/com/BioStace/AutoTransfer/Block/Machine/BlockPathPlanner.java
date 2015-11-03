package com.BioStace.AutoTransfer.Block.Machine;

import com.BioStace.AutoTransfer.AutoTransfer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPathPlanner extends BlockContainer{

	public BlockPathPlanner() {
		super(Material.iron);
		// TODO Auto-generated constructor stub
		this.setBlockName("PathPlanner");
		this.setCreativeTab(AutoTransfer.autotransfer);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(2F);
		
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
