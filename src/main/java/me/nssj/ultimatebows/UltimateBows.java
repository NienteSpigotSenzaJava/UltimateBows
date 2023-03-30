package me.nssj.ultimatebows;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.commands.UBowsCommand;
import me.nssj.ultimatebows.listeners.ArrowListener;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateBows extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager plm = getServer().getPluginManager();
        System.out.println("UltimateBows has started.");

        plm.registerEvents(new ArrowListener(), this);
        getCommand("ubows").setExecutor(new UBowsCommand());

        new Bow(ChatColor.RED + "" + ChatColor.BOLD + "Destruction Bow", new String[]{"This bow destroys everything."});
        new Bow(ChatColor.AQUA + "" + ChatColor.BOLD + "Player Bow", new String[]{"This bow shoots arrows that bring", "you with them."});
        new Bow(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleport Bow", new String[]{"This bow shoots arrows that teleports", "you at their position."});
        new Bow(ChatColor.GOLD + "" + ChatColor.BOLD + "Explosive Bow", new String[]{"This bow shoots explosive arrows."});
        new Bow(ChatColor.BLUE + "" + ChatColor.BOLD + "Water Bow", new String[]{"This bow shoots arrows that make water."});
        new Bow(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Lava Bow", new String[]{"This bow shoots arrows that make lava."});

    }

}
