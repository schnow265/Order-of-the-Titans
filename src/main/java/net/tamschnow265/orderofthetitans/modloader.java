package net.tamschnow265.orderofthetitans;

import net.fabricmc.api.ModInitializer;
import net.tamschnow265.orderofthetitans.blocks.ModBlocks;
import net.tamschnow265.orderofthetitans.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class modloader implements ModInitializer {
	public static final String MOD_ID ="orderofthetitans";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Tell the User the mod starts loading
		LOGGER.info("Starting to insert code from the Titans...");
		
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//Inform the User that the mod has loaded - for Error checking in the logs
		LOGGER.info("The Titans' binarys is now inserted into Minecraft");
	}
}
