package me.nssj.ultimatebows.listeners;

import me.nssj.ultimatebows.bows.Bow;
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

public final class ArrowListener implements Listener {

    private final BowManager bowManager;

    public ArrowListener(final BowManager bowManager) {

        this.bowManager = bowManager;

    }


    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent e) {

        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {

            Arrow arrow = (Arrow) e.getEntity();
            Player player = (Player) arrow.getShooter();

            ItemStack item = player.getInventory().getItemInMainHand();

            if (isBow("destructionBow", item)) {

                destructionBow(e.getHitBlock());

            } else if (isBow("teleportBow", item)) {

                teleportBow(player, arrow);

            } else if (isBow("explosiveBow", item)) {

                explosiveBow(e.getHitBlock(), arrow);

            } else if (isBow("waterBow", item)) {

                waterBow(e.getHitBlock(), arrow);

            } else if (isBow("lavaBow", item)) {

                lavaBow(e.getHitBlock(), arrow);

            }

        }

    }

    @EventHandler
    public void onProjectileLaunch(final ProjectileLaunchEvent e) {

        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {

            Arrow arrow = (Arrow) e.getEntity();
            Player player = (Player) arrow.getShooter();

            ItemStack item = player.getInventory().getItemInMainHand();

            if (isBow("playerBow", item)) {

                playerBow(arrow, player);

            }

        }

    }

    private boolean isBow(String name, ItemStack item) {

        return item.getItemMeta().getLore().equals(bowManager.getBowItem(bowManager.getBow(name)).getItemMeta().getLore());

    }

    private void destructionBow(Block hitBlock) {

        hitBlock.breakNaturally();

    }

    private void teleportBow(Player player, Arrow arrow) {

        player.teleport(arrow);

    }

    private void explosiveBow(Block hitBlock, Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.getWorld().createExplosion(hitBlock.getLocation(), 3.0f, true);
            arrow.remove();

        }

    }

    private void waterBow(Block hitBlock, Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.setType(Material.WATER);
            arrow.remove();

        }

    }

    private void lavaBow(Block hitBlock, Arrow arrow) {

        if (hitBlock != null) {

            hitBlock.setType(Material.LAVA);
            arrow.remove();

        }

    }

    private void playerBow(Arrow arrow, Player player) {

        arrow.addPassenger(player);

    }

}
