package com.BioStace.AutoTransfer.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.BioStace.AutoTransfer.AutoTransfer;
import com.BioStace.AutoTransfer.Registry.BlockRegistry;
import com.BioStace.AutoTransfer.line.LineMannager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockStation extends Block {
	List<Boolean> r = new ArrayList();

	public BlockStation() {
		super(Material.iron);
		this.setCreativeTab(AutoTransfer.autotransfer);
		this.setHardness(4.0F);
		this.setBlockName("station");
		this.setStepSound(soundTypeStone);
	}

	/*
	 * Block State
	 */

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		// 0 - N, 1 - S, 2 - W, 3 - E
		r.add(world.getBlock(x, y, z - 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x, y, z + 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x - 1, y, z) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x + 1, y, z) == BlockRegistry.transOrbit);
		if (r.get(0)) {
			Vector v = LineMannager.getClosestPoint(world, x, y, z - 1);
			if (v != null)
				System.out.println(v.get(0) + ", " + v.get(1) + ", " + v.get(2));
		}	
		if (r.get(1)) {
			Vector v = LineMannager.getClosestPoint(world, x, y, z + 1);
			if (v != null)
				System.out.println(v.get(0) + ", " + v.get(1) + ", " + v.get(2));
		}
		if (r.get(2)) {
			Vector v = LineMannager.getClosestPoint(world, x - 1, y, z);
			if (v != null)
				System.out.println(v.get(0) + ", " + v.get(1) + ", " + v.get(2));
		}
		if (r.get(3)) {
			Vector v = LineMannager.getClosestPoint(world, x + 1, y, z);
			if (v != null)
				System.out.println(v.get(0) + ", " + v.get(1) + ", " + v.get(2));
		}
	}

	/*
	 * Block Place
	 */
	
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack stack) {
		int i = MathHelper
				.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
		if (i == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		if (i == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		if (i == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		if (i == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		this.onNeighborBlockChange(world, x, y, z, world.getBlock(x, y, z));
	}
}
