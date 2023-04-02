package me.nssj.ultimatebows.bows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public final class BowManager {

    private final ArrayList<Bow> bows;

    public BowManager(final ArrayList<Bow> bows) {

        this.bows = bows;

    }


    public Bow getBow(final String name) {

        for (final Bow bow : bows) {

            if (ChatColor.stripColor(bow.getName().replaceAll("\\s+", "")).equalsIgnoreCase(name)) {

                return bow;

            }
        }

        return null;

    }

    public ItemStack getBowItem(final Bow bow) {

        final ItemStack item = new ItemStack(Material.BOW);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(bow.getName());
        meta.setLore(new ArrayList<>(Arrays.asList(bow.getDescription())));

        item.setItemMeta(meta);

        return item;

    }

}
