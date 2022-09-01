package net.tamschnow265.orderofthetitans.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tamschnow265.orderofthetitans.modloader;

public class ModItems {
    
    //Items
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite", new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE = registerItem("tanzanite", new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));




    //Registering
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(modloader.MOD_ID, name), item);
    }

    public static void registerModItems() {
        modloader.LOGGER.info("Registering Items for " + modloader.MOD_ID);
    }

}
