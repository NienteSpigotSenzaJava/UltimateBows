package me.nssj.ultimatebows.bows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowsManager {
    private static final List<Bow> bows = new ArrayList<>();

    public static void addBow(Bow bow) {
        bows.add(bow);
    }

    public static List<Bow> getBows() {
        return bows;
    }

    public static Bow getBowByName(String name) {
        for (Bow bow : BowsManager.getBows()) {
            if (ChatColor.stripColor(bow.getName().replaceAll("\\s+", "")).equalsIgnoreCase(name)) {
                return bow;
            }
        }
        return null;
    }

    public static ItemStack getBowItem(Bow bow) {
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
