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

        new Bow(ChatColor.RED + "" + ChatColor.BOLD + "Destruction Bow", new String[]{"This bow destroys everything."}, "destroy");
        new Bow(ChatColor.AQUA + "" + ChatColor.BOLD + "Player Bow", new String[]{"This bow shoots arrows that bring you with them."}, "passenger");
    }

}
