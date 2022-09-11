package net.tamschnow265.orderofthetitans.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.tamschnow265.orderofthetitans.world.feature.PlaceFeature;

public class OreGen {
    public static void generateOres() {
        Object ModPlacedFeatures;
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, PlaceFeature.TANZANITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, PlaceFeature.NETHER_TANZANITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, PlaceFeature.END_TANZANITE_ORE_PLACED.getKey().get());
    }

}
