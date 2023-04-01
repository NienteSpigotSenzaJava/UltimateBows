package me.nssj.ultimatebows.utils;

import org.bukkit.entity.*;

public enum MobType {

    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN),
    WITHER_SKELETON(EntityType.WITHER_SKELETON),
    STRAY(EntityType.STRAY),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER),
    SKELETON_HORSE(EntityType.SKELETON_HORSE),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE),
    DONKEY(EntityType.DONKEY),
    MULE(EntityType.MULE),
    EVOKER_FANGS(EntityType.EVOKER_FANGS),
    EVOKER(EntityType.EVOKER),
    VEX(EntityType.VEX),
    VINDICATOR(EntityType.VINDICATOR),
    ILLUSIONER(EntityType.ILLUSIONER),
    CREEPER(EntityType.CREEPER),
    SKELETON(EntityType.SKELETON),
    SPIDER(EntityType.SPIDER),
    GIANT(EntityType.GIANT),
    ZOMBIE(EntityType.ZOMBIE),
    SLIME(EntityType.SLIME),
    GHAST(EntityType.GHAST),
    ZOMBIFIED_PIGLIN(EntityType.ZOMBIFIED_PIGLIN),
    ENDERMAN(EntityType.ENDERMAN),
    CAVE_SPIDER(EntityType.CAVE_SPIDER),
    SILVERFISH(EntityType.SILVERFISH),
    BLAZE(EntityType.BLAZE),
    MAGMA_CUBE(EntityType.MAGMA_CUBE),
    ENDER_DRAGON(EntityType.ENDER_DRAGON),
    WITHER(EntityType.WITHER),
    BAT(EntityType.BAT),
    WITCH(EntityType.WITCH),
    ENDERMITE(EntityType.ENDERMITE),
    GUARDIAN(EntityType.GUARDIAN),
    SHULKER(EntityType.SHULKER),
    PIG(EntityType.PIG),
    SHEEP(EntityType.SHEEP),
    COW(EntityType.COW),
    CHICKEN(EntityType.CHICKEN),
    SQUID(EntityType.SQUID),
    WOLF(EntityType.WOLF),
    MUSHROOM_COW(EntityType.MUSHROOM_COW),
    SNOWMAN(EntityType.SNOWMAN),
    OCELOT(EntityType.OCELOT),
    IRON_GOLEM(EntityType.IRON_GOLEM),
    HORSE(EntityType.HORSE),
    RABBIT(EntityType.RABBIT),
    POLAR_BEAR(EntityType.POLAR_BEAR),
    LLAMA(EntityType.LLAMA),
    LLAMA_SPIT(EntityType.LLAMA_SPIT),
    PARROT(EntityType.PARROT),
    VILLAGER(EntityType.VILLAGER),
    TURTLE(EntityType.TURTLE),
    PHANTOM(EntityType.PHANTOM),
    COD(EntityType.COD),
    SALMON(EntityType.SALMON),
    PUFFERFISH(EntityType.PUFFERFISH),
    TROPICAL_FISH(EntityType.TROPICAL_FISH),
    DROWNED(EntityType.DROWNED),
    DOLPHIN(EntityType.DOLPHIN),
    CAT(EntityType.CAT),
    PANDA(EntityType.PANDA),
    PILLAGER(EntityType.PILLAGER),
    RAVAGER(EntityType.RAVAGER),
    TRADER_LLAMA(EntityType.TRADER_LLAMA),
    WANDERING_TRADER(EntityType.WANDERING_TRADER),
    FOX(EntityType.FOX),
    BEE(EntityType.BEE),
    HOGLIN(EntityType.HOGLIN),
    PIGLIN(EntityType.PIGLIN),
    STRIDER(EntityType.STRIDER),
    ZOGLIN(EntityType.ZOGLIN),
    PIGLIN_BRUTE(EntityType.PIGLIN_BRUTE),
    AXOLOTL(EntityType.AXOLOTL),
    GLOW_SQUID(EntityType.GLOW_SQUID),
    GOAT(EntityType.GOAT),
    ALLAY(EntityType.FOX),
    FROG(EntityType.RABBIT),
    TADPOLE(EntityType.SALMON),
    WARDEN(EntityType.UNKNOWN);

    private final EntityType entityType;

    MobType(final EntityType entityType) {

        this.entityType = entityType;

    }


    public EntityType getEntityType() {

        return entityType;

    }

}
