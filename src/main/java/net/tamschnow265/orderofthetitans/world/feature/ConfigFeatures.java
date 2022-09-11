package net.tamschnow265.orderofthetitans.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.tamschnow265.orderofthetitans.blocks.ModBlocks;
import net.tamschnow265.orderofthetitans.modloader;

import java.util.List;

public class ConfigFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_TANZANITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TANZANITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> NETHER_TANZANITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocks.NETHERRACK_TANZANITE_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> END_TANZANITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDSTONE_TANZANITE_ORE.getDefaultState()));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TANZANITE_ORE =
            ConfiguredFeatures.register("tanzanite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_TANZANITE_ORE =
            ConfiguredFeatures.register("nether_tanzanite_ore", Feature.ORE, new OreFeatureConfig(NETHER_TANZANITE_ORES, 12));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_TANZANITE_ORE =
            ConfiguredFeatures.register("end_tanzanite_ore",Feature.ORE, new OreFeatureConfig(END_TANZANITE_ORES, 12));

    public static void registerConfiguredFeatures() {
        modloader.LOGGER.debug("Registering the ModConfiguredFeatures for " + modloader.MOD_ID);
    }

}
