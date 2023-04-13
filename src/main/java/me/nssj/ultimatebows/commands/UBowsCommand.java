package me.nssj.ultimatebows.commands;

import me.nssj.ultimatebows.bows.Bow;
import me.nssj.ultimatebows.bows.BowManager;
import me.nssj.ultimatebows.utils.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class UBowsCommand implements CommandExecutor, TabCompleter {

    private final BowManager bowManager;

    public UBowsCommand(final BowManager bowManager) {

        this.bowManager = bowManager;

    }


    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {

                if (args[1].equalsIgnoreCase("all")) {

                    for (final Bow bow : bowManager.getBows()) {

                        player.getInventory().addItem(bowManager.getBowItem(bow));

                    }

                } else {

                    final Bow bow = bowManager.getBow(args[1]);

                    if (bow != null) {

                        player.getInventory().addItem(bowManager.getBowItem(bow));

                    } else {

                        player.sendMessage(Utils.getColorizedText(ChatColor.RED, true, "The bow " + args[1] + " doesn't exist!"));

                    }

                }

            } else {

                player.sendMessage(Utils.getColorizedText(ChatColor.RED, true, "Syntax: /ubows give <bowName>"));

            }

        }

        return true;

    }

    @Override
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {

        if (args.length == 1) {

            return StringUtil.copyPartialMatches(args[0], Collections.singletonList("give"), new ArrayList<>());

        } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {

            return StringUtil.copyPartialMatches(args[1], Arrays.asList("all", "destructionBow", "playerBow", "teleportBow", "explosiveBow", "waterBow", "lavaBow", "lightningBow", "mobBow", "fireBow"), new ArrayList<>());

        }

        return null;

    }

}
