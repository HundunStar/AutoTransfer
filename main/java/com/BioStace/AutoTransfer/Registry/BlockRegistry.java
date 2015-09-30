package com.BioStace.AutoTransfer.Registry;

import com.BioStace.AutoTransfer.Block.BlockTransOrbit;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegistry {
	public static Block transOrbit;
	
	public static void init () {
		transOrbit = new BlockTransOrbit();
		registry();
	}
	
	public static void registry () {
		GameRegistry.registerBlock(transOrbit, "transOrbit");
	}
}
