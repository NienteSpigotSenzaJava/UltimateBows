package me.nssj.ultimatebows.listeners;

import me.nssj.ultimatebows.bows.BowManager;
import me.nssj.ultimatebows.utils.MobType;
import me.nssj.ultimatebows.utils.PotionsType;

import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;

import java.util.Objects;

public final class ArrowListener implements Listener {

    private final BowManager bowManager;

    public ArrowListener(final BowManager bowManager) {

        this.bowManager = bowManager;

    }


    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent event) {

        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {

            Arrow arrow = (Arrow) event.getEntity();
            Player player = (Player) arrow.getShooter();

            ItemStack item = player.getInventory().getItemInMainHand();

            if (isBow("destructionBow", item)) {

                destructionBow(event.getHitBlock(), arrow);

            } else if (isBow("teleportBow", item)) {

                teleportBow(player, arrow);

            } else if (isBow("explosiveBow", item)) {

                explosiveBow(event.getHitBlock(), arrow);

            } else if (isBow("waterBow", item)) {

                waterBow(event.getHitBlock(), arrow);

            } else if (isBow("lavaBow", item)) {

                lavaBow(event.getHitBlock(), arrow);

            } else if (isBow("mobBow", item)) {

                mobBow(arrow);

            } else if (isBow("lightningBow", item)) {

                lightningBow(arrow);

            } else if (isBow("playerBow", item)) {

                arrow.remove();

            } else if (isBow("potionBow", item)) {

                potionBow(arrow);

            }

        }

    }

    @EventHandler
    public void onProjectileLaunch(final ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {

            final Arrow arrow = (Arrow) event.getEntity();
            final Player player = (Player) arrow.getShooter();

            final ItemStack item = player.getInventory().getItemInMainHand();

            if (isBow("playerBow", item)) {

                playerBow(arrow, player);

            } else if (isBow("fireBow", item)) {

                fireBow(arrow);

            }

        }

    }


    private boolean isBow(final String name, final ItemStack item) {

        return Objects.equals(item.getItemMeta().getLore(), bowManager.getBowItem(bowManager.getBow(name)).getItemMeta().getLore());

    }

    private void destructionBow(final Block hitBlock, final Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.breakNaturally();
            arrow.remove();

        }

    }

    private void teleportBow(final Player player, final Arrow arrow) {

        player.teleport(arrow);
        arrow.remove();

    }

    private void explosiveBow(final Block hitBlock, final Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.getWorld().createExplosion(hitBlock.getLocation(), 3.0f, true);
            arrow.remove();

        }

    }

    private void waterBow(final Block hitBlock, final Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.setType(Material.WATER);
            arrow.remove();

        }

    }

    private void lavaBow(final Block hitBlock, final Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.setType(Material.LAVA);
            arrow.remove();

        }

    }

    private void mobBow(final Arrow arrow) {

        arrow.getWorld().spawnEntity(arrow.getLocation(), MobType.values()[(int) (Math.random() * (MobType.values().length))].getEntityType());
        arrow.remove();

    }

    private void lightningBow(final Arrow arrow) {

        arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.LIGHTNING);
        arrow.remove();

    }

    private void playerBow(final Arrow arrow, final Player player) {

        arrow.addPassenger(player);

    }

    private void fireBow(final Arrow arrow) {

        arrow.remove();

        Fireball fireball = (Fireball) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.FIREBALL);
        fireball.setDirection(arrow.getVelocity());

        fireball.setIsIncendiary(true);
        fireball.setYield(1);

    }

    private void potionBow(final Arrow arrow) {

        arrow.remove();

        ItemStack potion = (ItemStack) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.SPLASH_POTION);
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        potionMeta.setBasePotionData(new PotionData(PotionsType.values()[(int) (Math.random() * (PotionsType.values().length))].getPotionType()));
        potion.setItemMeta(potionMeta);

    }

}
