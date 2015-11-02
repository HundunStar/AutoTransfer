package com.BioStace.AutoTransfer.TileEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityTransCartNormal extends TileEntity implements IInventory{

	public ItemStack[] stacks=new ItemStack[36];

	public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readFromNBT(p_70037_1_);
        NBTTagList nbttaglist = p_70037_1_.getTagList("transItems", 10);
        this.stacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("transSlot") & 255;

            if (j >= 0 && j < this.stacks.length)
            {
                this.stacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

	public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeToNBT(p_70014_1_);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.stacks.length; ++i)
        {
            if (this.stacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("transSlot", (byte)i);
                this.stacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_70014_1_.setTag("transItems", nbttaglist);
    }

	@Override
	public int getSizeInventory() {
		// TODO 自动生成的方法存根
		return 36;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO 自动生成的方法存根
		return stacks[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int stack) {
		// TODO 自动生成的方法存根
		if(this.stacks[index] != null){
			ItemStack i;
			if(this.stacks[index].stackSize <= stack){
				i=this.stacks[index];
				this.stacks[index]=null;
				return i;
			}else{
				i=this.stacks[index].splitStack(stack);
				if(this.stacks[index].stackSize==0){
					this.stacks[index]=null;
				}
				return i;
			}
		}
		else{
			
		return null;
		
	   }
	}
		

	   public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	    {
	        if (this.stacks[p_70304_1_] != null)
	        {
	            ItemStack itemstack = this.stacks[p_70304_1_];
	            this.stacks[p_70304_1_] = null;
	            return itemstack;
	        }
	        else
	        {
	            return null;
	        }
	    }

	@Override
	  public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.stacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }


	@Override
	public String getInventoryName() {
		// TODO 自动生成的方法存根
		return "inventory.transcart";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO 自动生成的方法存根
		return 64;
	}

	@Override
	public void markDirty() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void openInventory() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void closeInventory() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
