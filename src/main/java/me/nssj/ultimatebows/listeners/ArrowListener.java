package me.nssj.ultimatebows.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.entity.Projectile;


public class ArrowListener implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();

            if (arrow.getShooter() instanceof Player) {
                Player player = (Player) arrow.getShooter();
                Block block = e.getHitBlock();

                if (player.getInventory().getItemInMainHand().getType() == Material.BOW) {
                    if (block != null) block.breakNaturally();
                }
            }

        }
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile instanceof Arrow && projectile.getShooter() instanceof Player) {
            Player player = (Player) projectile.getShooter();
            Arrow arrow = (Arrow) projectile;
            arrow.addPassenger(player);
        }
    }

}
