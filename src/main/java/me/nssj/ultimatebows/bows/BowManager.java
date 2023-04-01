package me.nssj.ultimatebows.bows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BowManager {

    private final List<Bow> bows;

    public BowManager(final ArrayList<Bow> bows) {

        this.bows = bows;

    }

    public List<Bow> getBows() {

        return bows;

    }

    public Bow getBowByName(String name) {

        for (Bow bow : getBows()) {

            if (ChatColor.stripColor(bow.getName().replaceAll("\\s+", "")).equalsIgnoreCase(name)) {

                return bow;

            }
        }

        return null;

    }

    public ItemStack getBowItem(Bow bow) {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(bow.getName());
        meta.setCustomModelData(6969);
        ArrayList<String> lore = new ArrayList<>(Arrays.asList(bow.getDescription()));

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;

    }

}
