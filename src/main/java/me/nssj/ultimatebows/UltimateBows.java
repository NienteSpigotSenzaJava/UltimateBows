package me.nssj.ultimatebows;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowManager;
import me.nssj.ultimatebows.commands.UBowsCommand;
import me.nssj.ultimatebows.listeners.ArrowListener;

import me.nssj.ultimatebows.utils.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public final class UltimateBows extends JavaPlugin {

    private ConsoleCommandSender console;

    private PluginManager pluginManager;

    private BowManager bowManager;

    @Override
    public void onEnable() {

        console = getServer().getConsoleSender();

        bowManager = new BowManager(new ArrayList<>(

                Arrays.asList(
                        new Bow(Util.getColorizedText(ChatColor.RED, true, "Destruction Bow"), new String[]{"This bow destroys everything."}),
                        new Bow(Util.getColorizedText(ChatColor.AQUA, true, "Player Bow"), new String[]{"This bow shoots arrows that bring", "you with them."}),
                        new Bow(Util.getColorizedText(ChatColor.YELLOW, true, "Teleport Bow"), new String[]{"This bow shoots arrows that teleports", "you to their position."}),
                        new Bow(Util.getColorizedText(ChatColor.GOLD, true, "Explosive Bow"), new String[]{"This bow shoots explosive arrows."}),
                        new Bow(Util.getColorizedText(ChatColor.BLUE, true, "Water Bow"), new String[]{"This bow shoots arrows that make water."}),
                        new Bow(Util.getColorizedText(ChatColor.DARK_RED, true, "Lava Bow"), new String[]{"This bow shoots arrows that make lava."})
                )

        ));

        pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new ArrowListener(bowManager), this);

        getCommand("ubows").setExecutor(new UBowsCommand(bowManager));

        console.sendMessage("UltimateBows was enabled successfully!");

    }

    @Override
    public void onDisable() {

        console.sendMessage("UltimateBows was disabled!");

    }


    public BowManager getBowManager() {

        return bowManager;

    }

}
