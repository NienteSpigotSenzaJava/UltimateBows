package me.nssj.ultimatebows.utils;

import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionType;

public enum PotionsType {

    AWKWARD(PotionType.AWKWARD),
    FIRE_RESISTANCE(PotionType.FIRE_RESISTANCE),
    INVISIBILITY(PotionType.INVISIBILITY),
    LUCK(PotionType.LUCK),
    NIGHT_VISION(PotionType.NIGHT_VISION),
    POISON(PotionType.POISON),
    SLOWNESS(PotionType.SLOWNESS),
    STRENGTH(PotionType.STRENGTH),
    WATER_BREATHING(PotionType.WATER_BREATHING),
    WEAKNESS(PotionType.WEAKNESS),
    TURTLE_MASTER(PotionType.TURTLE_MASTER),
    SLOW_FALLING(PotionType.SLOW_FALLING);

    private final PotionType potionType;

    PotionsType(final PotionType potionType) {

        this.potionType = potionType;

    }


    public PotionType getPotionType() {

        return potionType;

    }

}
