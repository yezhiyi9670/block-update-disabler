package com.ak_ioi.blockupdatedisabler.blocks;

import java.util.Random;

import net.minecraft.block.BlockConcretePowder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ConcretePowder extends BlockConcretePowder {
	public ConcretePowder() {
		this.setUnlocalizedName("concretePowder");
		this.setRegistryName(new ResourceLocation("minecraft", "concrete_powder"));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (!worldIn.getGameRules().getBoolean("preventFallingBlocks"))
			super.updateTick(worldIn, pos, state, rand);
    }
}
