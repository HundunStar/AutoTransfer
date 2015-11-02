package com.BioStace.AutoTransfer.Entity;

import com.BioStace.AutoTransfer.Registry.BlockRegistry;
import com.jcraft.jorbis.Block;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

//both these two classes are not finished,I need to learn about meta and its rotation

public class EntityTransCartBase extends Entity{

	
	public EntityTransCartBase(World p_i1582_1_) {
		super(p_i1582_1_);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void entityInit() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO 自动生成的方法存根
		super.readFromNBT(p_70037_1_);
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO 自动生成的方法存根
		super.writeToNBT(p_70014_1_);
		
	}
	
	public void handleCratMovement(float f){
		double x=this.posX;
		double y=this.posY;
		double z=this.posZ;
		this.motionX *= 0.88;
		this.motionY *= 0.88;
		this.motionZ *= 0.88;
		
				
	}
	
	public float getRotation(){
		int x=MathHelper.floor_double(this.posX);
		int y=MathHelper.floor_double(this.posY);
		int z=MathHelper.floor_double(this.posZ);
		int meta=this.worldObj.getBlock(x, y, z).getDamageValue(worldObj, x, y, z);
		if(isOnRail(x,y,z)){
		switch(meta){
		
		
		
		
		
		}
		
			
		}
		return meta;
	}
	
	@Override
	public void applyEntityCollision(Entity p_70108_1_){
		int x=MathHelper.floor_double(this.posX);
		int y=MathHelper.floor_double(this.posY);
		int z=MathHelper.floor_double(this.posZ);
				
		double speed= isOnRail(x, y, z)?5:1;
		if (p_70108_1_.riddenByEntity != this && p_70108_1_.ridingEntity != this)
        {
            double d0 = p_70108_1_.posX - this.posX;
            double d1 = p_70108_1_.posZ - this.posZ;
            double d2 = MathHelper.abs_max(d0, d1);

            if (d2 >= 0.009999999776482582D)
            {
                d2 = (double)MathHelper.sqrt_double(d2);
                d0 /= d2;
                d1 /= d2;
                double d3 = 1.0D / d2;

                if (d3 > 1.0D)
                {
                    d3 = 1.0D;
                }

                d0 *= d3;
                d1 *= d3;
                d0 *= 0.05000000074505806D;
                d1 *= 0.05000000074505806D;
                d0 *= (double)(1.0F - this.entityCollisionReduction);
                d1 *= (double)(1.0F - this.entityCollisionReduction);
                this.addVelocity(-d0, 0.0D, -d1);
                p_70108_1_.addVelocity(d0*speed, 0.0D, d1*speed);
            }
        }
				
		
	}
	
	public boolean isOnRail(int x,int y,int z){
		
		if(this.worldObj.getBlock(x,y,z)==BlockRegistry.transOrbit||this.worldObj.getBlock(x, y-1, z)==BlockRegistry.transOrbit){
			return true;
		}
		else{
			return false;
		}
	}

}
