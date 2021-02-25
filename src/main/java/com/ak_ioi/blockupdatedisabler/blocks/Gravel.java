package com.ak_ioi.blockupdatedisabler.blocks;

import java.util.Random;

import net.minecraft.block.BlockGravel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Gravel extends BlockGravel {
	public Gravel() {
		this.setUnlocalizedName("gravel");
		this.setRegistryName(new ResourceLocation("minecraft", "gravel"));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (!worldIn.getGameRules().getBoolean("preventFallingBlocks"))
			super.updateTick(worldIn, pos, state, rand);
    }
}
