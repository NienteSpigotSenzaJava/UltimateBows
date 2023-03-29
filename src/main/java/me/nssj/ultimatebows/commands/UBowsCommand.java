package me.nssj.ultimatebows.commands;

import me.nssj.ultimatebows.bows.Bow;

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

import static me.nssj.ultimatebows.bows.Bow.*;

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
                Bow bow = getBowByName(args[1]);

                if (getBows().contains(bow)) {
                    ItemStack bowItem = getBowItem(bow);
                    player.getInventory().addItem(bowItem);
                }
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("give"), new ArrayList<>());
        } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("destructionBow", "playerBow"), new ArrayList<>());
        }
        return null;
    }
}
