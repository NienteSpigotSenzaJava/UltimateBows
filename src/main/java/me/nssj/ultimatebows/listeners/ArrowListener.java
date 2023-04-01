package me.nssj.ultimatebows.listeners;

import me.nssj.ultimatebows.bows.BowManager;

import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

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

            } else if (isBow("playerBow", item)) {

                arrow.remove();

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

    private void playerBow(final Arrow arrow, final Player player) {

        arrow.addPassenger(player);

    }

}
