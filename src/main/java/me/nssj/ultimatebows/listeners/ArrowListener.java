package me.nssj.ultimatebows.listeners;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowManager;
import me.nssj.ultimatebows.utils.MobType;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class ArrowListener implements Listener {

    private final BowManager bowManager;
    private final HashMap<UUID, String> arrows = new HashMap<>();

    public ArrowListener(final BowManager bowManager) {

        this.bowManager = bowManager;

    }


    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent event) {

        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {

            Arrow arrow = (Arrow) event.getEntity();
            Player player = (Player) arrow.getShooter();

            if (arrows.get(arrow.getUniqueId()) != null) {

                if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("destructionBow")) {

                    destructionBow(event.getHitBlock(), arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("teleportBow")) {

                    teleportBow(player, arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("explosiveBow")) {

                    explosiveBow(event.getHitBlock(), arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("waterBow")) {

                    waterBow(event.getHitBlock(), event.getHitBlockFace(), arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("lavaBow")) {

                    lavaBow(event.getHitBlock(), event.getHitBlockFace(), arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("mobBow")) {

                    mobBow(arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("lightningBow")) {

                    lightningBow(arrow);

                } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("playerBow")) {

                    arrow.remove();

                }

            }

        }

    }

    @EventHandler
    public void onProjectileLaunch(final ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow && event.getEntity().getShooter() instanceof Player) {

            final Arrow arrow = (Arrow) event.getEntity();
            final Player player = (Player) arrow.getShooter();

            final ItemStack item = player.getInventory().getItemInMainHand();
            final Bow bow = getUltimateBow(item);

            if (bow != null) {

                String bowName = ChatColor.stripColor(bow.getName().replaceAll("\\s+", "")).toLowerCase();

                if (!player.hasPermission("ultimatebows.use." + bowName)) {

                    player.sendMessage(ChatColor.RED + "You don't have permission to do that.");
                    arrow.remove();
                    return;

                }

                arrows.put(arrow.getUniqueId(), bowName);

            }

            if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("playerBow")) {

                playerBow(arrow, player);

            } else if (arrows.get(arrow.getUniqueId()).equalsIgnoreCase("fireBow")) {

                fireBow(arrow);

            }

        }

    }

    private Bow getUltimateBow(final ItemStack item) {

        for (Bow bow : bowManager.getBows()) {

            if (Objects.equals(item.getItemMeta().getLore(), bowManager.getBowItem(bow).getItemMeta().getLore())) {

                return bow;

            }

        }

        return null;

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

    private void waterBow(final Block hitBlock, final BlockFace blockFace, final Arrow arrow) {

        if (hitBlock != null) {

            Block block = hitBlock.getRelative(blockFace);

            block.setType(Material.WATER);
            arrow.remove();

        }

    }

    private void lavaBow(final Block hitBlock, final BlockFace blockFace, final Arrow arrow) {

        if (hitBlock != null) {

            Block block = hitBlock.getRelative(blockFace);

            block.setType(Material.LAVA);
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

}
