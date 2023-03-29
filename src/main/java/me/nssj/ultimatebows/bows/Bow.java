package me.nssj.ultimatebows.bows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bow {
    private final String name;
    private final String[] description;
    private final String usage;
    private static final List<Bow> bows = new ArrayList<>();;

    public Bow(String name, String[] description, String usage) {
        this.name = name;
        this.description = description;
        this.usage = usage;

        bows.add(this);
    }

    public String getName() {
        return name;
    }

    public String[] getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public static Bow getBowByName(String name) {
        for (Bow bow : bows) {
            if (ChatColor.stripColor(bow.name.replaceAll("\\s+", "")).equalsIgnoreCase(name)) {
                System.out.println("ei");
                return bow;
            }
        }
        return null;
    }

    public static List<Bow> getBows() {
        return bows;
    }

    public static ItemStack getBowItem(Bow bow) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(bow.name);
        ArrayList<String> lore = new ArrayList<>(Arrays.asList(bow.description));

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

}
