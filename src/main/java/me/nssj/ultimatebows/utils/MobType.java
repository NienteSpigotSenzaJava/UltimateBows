package me.nssj.ultimatebows.utils;

import org.bukkit.entity.EntityType;

public enum MobType {

    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN),
    WITHER_SKELETON(EntityType.WITHER_SKELETON),
    STRAY(EntityType.STRAY),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER),
    SKELETON_HORSE(EntityType.SKELETON_HORSE),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE),
    DONKEY(EntityType.DONKEY),
    MULE(EntityType.MULE),
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
    ENDERMAN(EntityType.ENDERMAN),
    CAVE_SPIDER(EntityType.CAVE_SPIDER),
    SILVERFISH(EntityType.SILVERFISH),
    BLAZE(EntityType.BLAZE),
    MAGMA_CUBE(EntityType.MAGMA_CUBE),
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
    PARROT(EntityType.PARROT),
    VILLAGER(EntityType.VILLAGER),
    TURTLE(EntityType.TURTLE),
    PHANTOM(EntityType.PHANTOM),
    COD(EntityType.COD),
    SALMON(EntityType.SALMON),
    PUFFERFISH(EntityType.PUFFERFISH),
    TROPICAL_FISH(EntityType.TROPICAL_FISH),
    DROWNED(EntityType.DROWNED),
    DOLPHIN(EntityType.DOLPHIN);

    private final EntityType entityType;

     MobType(final EntityType entityType) {

        this.entityType = entityType;

    }


    public EntityType getEntityType() {

        return entityType;

    }

}
