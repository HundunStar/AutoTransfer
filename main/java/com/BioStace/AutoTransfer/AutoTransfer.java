package com.BioStace.AutoTransfer;

import com.BioStace.AutoTransfer.Registry.*;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid=AutoTransfer.MODID,name=AutoTransfer.NAME,version=AutoTransfer.Version)
public class AutoTransfer {

	public static final String MODID="AutoTransMod";
	public static final String NAME="AutoTransfer";
	public static final String Version="1.0.1";
	
	public static CreativeTabs ATCreative = new ATCreativeTab();
	public static BlockRegistry block = new BlockRegistry();
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		block.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
	}
}
