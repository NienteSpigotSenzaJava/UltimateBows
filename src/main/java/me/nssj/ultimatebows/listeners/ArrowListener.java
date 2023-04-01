package me.nssj.ultimatebows.listeners;

import com.sun.tools.javac.jvm.Items;
import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowsManager;

import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class ArrowListener implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
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
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
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

        return item.getItemMeta().getLore().equals(BowsManager.getBowItem(BowsManager.getBowByName(name)).getItemMeta().getLore());

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
