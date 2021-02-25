package com.ak_ioi.blockupdatedisabler;

import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import com.ak_ioi.blockupdatedisabler.handler.DbuEventHandler;
import org.apache.logging.log4j.Logger;

@Mod(modid = DbuMain.MODID, name = DbuMain.NAME, version = DbuMain.VERSION)
public class DbuMain {
    public static final String MODID = "blockupdatedisabler";
    public static final String NAME = "Block Update Disabler";
    public static final String VERSION = "0.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new DbuEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
		World world = event.getServer().getEntityWorld();
		world.getGameRules().addGameRule("preventBlockUpdates", "true", GameRules.ValueType.BOOLEAN_VALUE);
		world.getGameRules().addGameRule("preventFallingBlocks", "true", GameRules.ValueType.BOOLEAN_VALUE);
   }
}
