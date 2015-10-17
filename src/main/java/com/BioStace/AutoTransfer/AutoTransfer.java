package com.BioStace.AutoTransfer;

import com.BioStace.AutoTransfer.Registry.BlockRegistry;
import com.BioStace.AutoTransfer.Registry.ItemRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AutoTransfer.MODID, name = AutoTransfer.NAME, version = AutoTransfer.Version)
public class AutoTransfer {

	public static final String MODID = "autotransmod";
	public static final String NAME = "AutoTransfer";
	public static final String Version = "1.0.1";
	public static ATCreativeTab autotransfer = new ATCreativeTab();

	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		BlockRegistry.init();
		ItemRegistry.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}
