package net.tamschnow265.orderofthetitans.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tamschnow265.orderofthetitans.modloader;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(new Identifier(modloader.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
