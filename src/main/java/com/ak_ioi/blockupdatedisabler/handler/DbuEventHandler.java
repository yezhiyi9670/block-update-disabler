package com.ak_ioi.blockupdatedisabler.handler;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.ak_ioi.blockupdatedisabler.blocks.*;

import net.minecraft.block.Block;

public class DbuEventHandler {
	public DbuEventHandler() {}
	
	// Priority minifies the chance of incompatibility.
	@SubscribeEvent(priority=EventPriority.HIGHEST)
	public void onNeighborNotify(NeighborNotifyEvent event) {
	    // Cancelling NeighborNotifyEvent can do the job.
		boolean flag = event.getWorld().getGameRules().getBoolean("preventBlockUpdates");
		if(flag && event.isCancelable())
	    	event.setCanceled(true);
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(new Sand(), new Gravel(), new Anvil(), new ConcretePowder());
    }
}
