package com.BioStace.AutoTransfer.Block;

import java.util.ArrayList;
import java.util.List;

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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTransOrbit extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray = new IIcon[6];
	@SideOnly(Side.CLIENT)
	private IIcon iconBase;

	/*
	 * metadata: 0 - NS, 1 - WE, 2 - NW, 3 - NE, 4 - SW, 5 - SE
	 * 0 - North-South(clock12-clock6,vertical line)
	 * 1 - West-East(clock9-clock3,horizontal line)
	 * 2 - North-West(clock12-clock9)
	 * 3 - North-East(clock12-clock3)
	 * 4 - South-West(clock6-clock9)
	 * 5 - South-East(clock6-clock3)
	 */

	public BlockTransOrbit() {
		super(Material.iron);
		this.setBlockName("transOrbit");
		this.setCreativeTab(AutoTransfer.autotransfer);
		this.setHardness(0.5f);
		this.setResistance(10.0f);
		this.setLightLevel(1.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockBounds(0.0f, 0.0f,0.0f, 1.0f,0.25f, 1.0f);
	}
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
	        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
	    }
	/*
	 * Block State
	 */

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		List<Boolean> r = new ArrayList(); // 0 - N, 1 - S, 2 - W, 3 - E
		r.add(world.getBlock(x, y, z - 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x, y, z + 1) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x - 1, y, z) == BlockRegistry.transOrbit);
		r.add(world.getBlock(x + 1, y, z) == BlockRegistry.transOrbit);
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

	public boolean isOpaqueCube() {
		return false;
	}

	/*
	 * Block Graph
	 */
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		if (side != 1) {
			return this.iconBase;
		}
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
		this.iconBase = arg0.registerIcon(AutoTransfer.MODID + ":transOrbit");
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
