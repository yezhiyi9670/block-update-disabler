package com.ak_ioi.blockupdatedisabler.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.world.BlockEvent.FluidPlaceBlockEvent;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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
}
