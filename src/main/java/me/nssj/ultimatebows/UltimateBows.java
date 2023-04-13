package me.nssj.ultimatebows;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowManager;
import me.nssj.ultimatebows.commands.UBowsCommand;
import me.nssj.ultimatebows.listeners.ArrowListener;
import me.nssj.ultimatebows.utils.Utils;

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
                        new Bow(Utils.getColorizedText(ChatColor.RED, true, "Destruction Bow"), new String[]{"This bow destroys everything."}),
                        new Bow(Utils.getColorizedText(ChatColor.AQUA, true, "Player Bow"), new String[]{"This bow shoots arrows that bring", "you with them."}),
                        new Bow(Utils.getColorizedText(ChatColor.YELLOW, true, "Teleport Bow"), new String[]{"This bow shoots arrows that teleports", "you to their position."}),
                        new Bow(Utils.getColorizedText(ChatColor.GOLD, true, "Explosive Bow"), new String[]{"This bow shoots explosive arrows."}),
                        new Bow(Utils.getColorizedText(ChatColor.BLUE, true, "Water Bow"), new String[]{"This bow shoots arrows that make water."}),
                        new Bow(Utils.getColorizedText(ChatColor.DARK_RED, true, "Lava Bow"), new String[]{"This bow shoots arrows that make lava."}),
                        new Bow(Utils.getColorizedText(ChatColor.DARK_AQUA, true, "Lightning Bow"), new String[]{"This bow shoots lightning."}),
                        new Bow(Utils.getColorizedText(ChatColor.DARK_GREEN, true, "Mob Bow"), new String[]{"This bow shoots mob spawning arrows."}),
                        new Bow(Utils.getColorizedText(ChatColor.GOLD, true, "Fire Bow"), new String[]{"This bow shoots fireballs."})
                )

        ));

        pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new ArrowListener(bowManager), this);

        getCommand("ubows").setExecutor(new UBowsCommand(bowManager));

        console.sendMessage("§6╔════════════════════════════════════════════╗");
        console.sendMessage("§6║§f                                            §6║");
        console.sendMessage("§6║§f            §bUltimateBows v1.0.1             §6║");
        console.sendMessage("§6║§f               §aPlugin enabled               §6║");
        console.sendMessage("§6║§f                                            §6║");
        console.sendMessage("§6╚════════════════════════════════════════════╝");
    }

    @Override
    public void onDisable() {

        console.sendMessage("§6╔════════════════════════════════════════════╗");
        console.sendMessage("§6║§f                                            §6║");
        console.sendMessage("§6║§f            §bUltimateBows v1.0.1             §6║");
        console.sendMessage("§6║§f              §cPlugin disabled               §6║");
        console.sendMessage("§6║§f                                            §6║");
        console.sendMessage("§6╚════════════════════════════════════════════╝");

    }

}
