package com.ak_ioi.blockupdatedisabler.blocks;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sand extends BlockSand {
	public Sand() {
		this.setUnlocalizedName("sand");
		this.setRegistryName(new ResourceLocation("minecraft", "sand"));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (!worldIn.getGameRules().getBoolean("preventFallingBlocks"))
			super.updateTick(worldIn, pos, state, rand);
    }
}
