package me.nssj.ultimatebows.listeners;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowsManager;

import org.bukkit.entity.Arrow;
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

            if (item.isSimilar(BowsManager.getBowItem(BowsManager.getBowByName("destructionBow")))) {
                e.getHitBlock().breakNaturally();
            } else if (item.isSimilar(BowsManager.getBowItem(BowsManager.getBowByName("teleportBow")))) {
                player.teleport(arrow);
            } else if (item.isSimilar(BowsManager.getBowItem(BowsManager.getBowByName("explosiveBow")))) {
                e.getHitBlock().getWorld().createExplosion(e.getHitBlock().getLocation(), 3.0f, true);
                arrow.remove();
            } else if (item.isSimilar(BowsManager.getBowItem(BowsManager.getBowByName("waterBow")))) {
                if (e.getHitBlock() != null) e.getHitBlock().setType(Material.WATER);
                arrow.remove();
            } else if (item.isSimilar(BowsManager.getBowItem(BowsManager.getBowByName("lavaBow")))) {
                if (e.getHitBlock() != null) e.getHitBlock().setType(Material.LAVA);
            }
        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {
            Arrow arrow = (Arrow) e.getEntity();
            Player player = (Player) arrow.getShooter();

            Bow bow = BowsManager.getBowByName("playerBow");
            if (player.getInventory().getItemInMainHand().isSimilar(BowsManager.getBowItem(bow))) {
                arrow.addPassenger(player);
            }
        }
    }

}
