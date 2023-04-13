package me.nssj.ultimatebows.utils;

import org.bukkit.ChatColor;

public final class Utils {

    public static String getColorizedText(final ChatColor color, final boolean bold, final String text) {

        final StringBuilder colorizedText = new StringBuilder();

        colorizedText.append(color);

        if (bold) {

            colorizedText.append(ChatColor.BOLD);

        }

        colorizedText.append(text);

        return colorizedText.toString();

    }

}
