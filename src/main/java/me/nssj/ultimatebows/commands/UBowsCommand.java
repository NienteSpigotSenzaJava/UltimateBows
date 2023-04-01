package me.nssj.ultimatebows.commands;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowsManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UBowsCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length != 2) {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Syntax: /ubows give <bowName>");
                return true;
            }

            if (args[0].equalsIgnoreCase("give")) {
                Bow bow = BowsManager.getBowByName(args[1]);

                if (BowsManager.getBows().contains(bow)) {
                    ItemStack bowItem = BowsManager.getBowItem(bow);
                    player.getInventory().addItem(bowItem);
                } else {
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Syntax: /ubows give <bowName>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Syntax: /ubows give <bowName>");
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("give"), new ArrayList<>());
        } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("destructionBow", "playerBow", "teleportBow", "explosiveBow", "waterBow", "lavaBow"), new ArrayList<>());
        }

        return null;
    }
}
