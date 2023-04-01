package me.nssj.ultimatebows.utils;

import org.bukkit.ChatColor;

public final class Util {

    public static String getColorizedText(ChatColor color, boolean bold, String text) {

        final StringBuilder colorizedText = new StringBuilder();

        colorizedText.append(color);

        if (bold) {

            colorizedText.append(ChatColor.BOLD);

        }

        colorizedText.append(text);

        return colorizedText.toString();

    }

}
