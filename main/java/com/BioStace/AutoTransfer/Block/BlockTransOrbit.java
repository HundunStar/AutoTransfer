package com.BioStace.AutoTransfer.Block;

import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.BiochemistryCraft;

import com.BioStace.AutoTransfer.AutoTransfer;
import com.BioStace.AutoTransfer.Registry.BlockRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockTransOrbit extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray = new IIcon[6];

	/*
	 * metadata: 0 - NS, 1 - WE, 2 - NW, 3 - NE, 4 - SW, 5 - SE
	 */

	public BlockTransOrbit() {
		super(Material.circuits);
		this.setBlockName("transOrbit");
		this.setCreativeTab(AutoTransfer.ct);
	}

	/*
	 * Block State
	 */

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		List<Boolean> r = getSide(world, x, y, z);
		int i = 0;
		for (boolean a : r) {
			if (a)
				i++;
		}
		if (i == 1) {
			if (r.get(0) || r.get(1)) {
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				return;
			}
			if (r.get(2) || r.get(3)) {
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				return;
			}
		}
		if (i == 2) {
			if (r.get(0) && r.get(1)) {
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				return;
			}
			if (r.get(2) && r.get(3)) {
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				return;
			}
			//=
			if (r.get(0) && r.get(2)) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				return;
			}
			if (r.get(0) && r.get(3)) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
				return;
			}
			if (r.get(1) && r.get(2)) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
				return;
			}
			if (r.get(1) && r.get(3)) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
				return;
			}
		}
	}

	/**
	 * 取轨道四周方块是否是轨道。
	 * 
	 * @param world
	 *            - 该方块所在的世界
	 * @param x
	 *            - 该方块的x
	 * @param y
	 *            - 该方块的y
	 * @param z
	 *            - 该方块的z
	 * @return 0 - N, 1 - S, 2 - W, 3 - E
	 */
	private List<Boolean> getSide(World world, int x, int y, int z) {
		List<Boolean> r = new ArrayList();
		r.add(world.getBlock(x, y, z - 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x, y, z + 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x - 1, y, z) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x + 1, y, z) == BlockRegistry.transOrbit);
		return r;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return null;
	}

	/*
	 * Block Graph
	 */
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		if (metadata > iconArray.length || metadata < 0) {
			metadata = 0;
		}
		return this.iconArray[metadata];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister arg0) {
		for (int i = 0; i < iconArray.length; i++) {
			this.iconArray[i] = arg0.registerIcon(AutoTransfer.MODID
					+ ":transOrbit_" + i);
		}
	}
	
	/*
	 * Block Place
	 */

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
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
