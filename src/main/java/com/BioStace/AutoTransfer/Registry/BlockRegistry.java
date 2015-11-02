package com.BioStace.AutoTransfer.Registry;

import com.BioStace.AutoTransfer.Block.*;
import com.BioStace.AutoTransfer.Block.Machine.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegistry {
	public static Block transOrbit;
	public static Block pathplanner;
	
	public static void init () {
		transOrbit = new BlockTransOrbit();
		pathplanner = new BlockPathPlanner();
		registry();
	}
	
	public static void registry () {
		GameRegistry.registerBlock(transOrbit, "transOrbit");
		GameRegistry.registerBlock(pathplanner, "PathPlanner");
	}
}
