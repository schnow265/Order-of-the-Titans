package net.tamschnow265.orderofthetitans.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.tamschnow265.orderofthetitans.blocks.ModBlocks;
import net.tamschnow265.orderofthetitans.item.ModItems;
import net.tamschnow265.orderofthetitans.modloader;

public class LordVillager {
    public static final PointOfInterestType LORD_POI = registerPOI("lord_poi", ModBlocks.TANZANITE_BLOCK);
    public static final VillagerProfession LORD_TRADER = registerProfession("lord_trader", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(modloader.MOD_ID, "lord_poi")));

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(modloader.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(modloader.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(modloader.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());

    }
    public static void registerVillagers () {
        modloader.LOGGER.info("Registering 2nd Villagers for " + modloader.MOD_ID);
    }


    public static void registerTrades() {

        // Trades for Level 1 aka "Welcome back to Trading Hell!"
        TradeOfferHelper.registerVillagerOffers(LORD_TRADER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TANZANITE, 64),
                            new ItemStack(Items.QUARTZ, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.QUARTZ, 3),
                            new ItemStack(Items.REINFORCED_DEEPSLATE, 1),
                            3, 10, 0.000001f
                    )));
                });

        // Trades for Level 2 aka "I could make these!"
        TradeOfferHelper.registerVillagerOffers(LORD_TRADER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.REINFORCED_DEEPSLATE, 3),
                            new ItemStack(Items.NETHER_BRICK, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.NETHER_BRICK, 30),
                            new ItemStack(Items.SCULK_CATALYST, 1),
                            3, 10, 0.000001f
                    )));
                });

        // Trades for Level 3 aka "Lush"
        TradeOfferHelper.registerVillagerOffers(LORD_TRADER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GRASS_BLOCK, 3),
                            new ItemStack(Items.MOSS_BLOCK, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.MOSS_BLOCK, 30),
                            new ItemStack(Items.AXOLOTL_BUCKET, 1),
                            3, 10, 0.000001f
                    )));
                });
    }
}
