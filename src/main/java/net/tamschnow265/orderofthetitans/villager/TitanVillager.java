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

public class TitanVillager {
    public static final PointOfInterestType URANIUM_POI = registerPOI("uranium_poi", ModBlocks.BLOCK_URANIUM);
    public static final VillagerProfession TITAN_TRADER = registerProfession("titan_trader", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(modloader.MOD_ID, "uranium_poi")));

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
        modloader.LOGGER.info("Registering 1st Villagers for " + modloader.MOD_ID);
    }



    public static void registerTrades() {

        // Trades for Level 1 aka "Project Overflow"
        TradeOfferHelper.registerVillagerOffers(TITAN_TRADER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TANZANITE, 64),
                            new ItemStack(Items.NETHERITE_INGOT, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.NETHERITE_INGOT, 3),
                            new ItemStack(Items.REINFORCED_DEEPSLATE, 1),
                            3, 10, 0.000001f
                    )));
                });

        // Trades for Level 2 aka "Project Amethyst"
        TradeOfferHelper.registerVillagerOffers(TITAN_TRADER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.REINFORCED_DEEPSLATE, 1),
                            new ItemStack(Items.AMETHYST_SHARD, 10),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.AMETHYST_SHARD, 64),
                            new ItemStack(Items.BUDDING_AMETHYST, 1),
                            90, 10, 0.000001f
                    )));
                });

        // Trades for Level 3 aka "Sculked"
        TradeOfferHelper.registerVillagerOffers(TITAN_TRADER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BUDDING_AMETHYST, 10),
                            new ItemStack(Items.SCULK_CATALYST, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.SCULK, 40),
                            new ItemStack(Items.WARDEN_SPAWN_EGG, 1),
                            3, 10, 0.000001f
                    )));
                });

        // Trades for Level 4 aka "Vanilla"
        TradeOfferHelper.registerVillagerOffers(TITAN_TRADER,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.WARDEN_SPAWN_EGG, 10),
                            new ItemStack(Items.BARRIER, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BARRIER, 5),
                            new ItemStack(Items.CRYING_OBSIDIAN, 1),
                            90, 10, 0.000001f
                    )));
                });

        // Trades for Level 5 aka "Up a Level!"
        TradeOfferHelper.registerVillagerOffers(TITAN_TRADER,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.CRYING_OBSIDIAN, 10),
                            new ItemStack(Items.VILLAGER_SPAWN_EGG, 1),
                            90, 10, 0.000001f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.CRYING_OBSIDIAN, 5),
                            new ItemStack(ModBlocks.TANZANITE_BLOCK, 1),
                            90, 10, 0.000001f
                    )));
                });
    }
}
