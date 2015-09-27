package com.BioStace.AutoTransfer.Registry;

import com.BioStace.AutoTransfer.Block.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRegistry {
	public static Block transorbit;
	public BlockRegistry()
	{
		transorbit=new BlockTransOrbit(Material.iron);
	}
	public void init()
	{
		GameRegistry.registerBlock(transorbit, "TransferOrbit");
	}
}
