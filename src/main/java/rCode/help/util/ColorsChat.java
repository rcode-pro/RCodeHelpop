package rCode.help.util;

import org.bukkit.ChatColor;

public class ColorsChat {

    public static String sendColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
