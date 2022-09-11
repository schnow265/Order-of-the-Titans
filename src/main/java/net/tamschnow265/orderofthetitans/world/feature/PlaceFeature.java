package net.tamschnow265.orderofthetitans.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class PlaceFeature {
    public static final RegistryEntry<PlacedFeature> TANZANITE_ORE_PLACED = PlacedFeatures.register("tanzanite_ore_placed",
            ConfigFeatures.TANZANITE_ORE, modifiersWithCount(9,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

    private static Object ConfigFratures;
    public static final RegistryEntry<PlacedFeature> NETHER_TANZANITE_ORE_PLACED = PlacedFeatures.register("nether_tanzanite_ore_placed",
            ConfigFeatures.NETHER_TANZANITE_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> END_TANZANITE_ORE_PLACED = PlacedFeatures.register("end_tanzanite_ore_placed",
            ConfigFeatures.END_TANZANITE_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));



    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

}
