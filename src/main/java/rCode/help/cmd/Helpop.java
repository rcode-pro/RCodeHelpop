package rCode.help.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rCode.help.Main;
import rCode.help.util.ColorsChat;
import rCode.help.util.CoolDown;

import java.util.HashMap;

public class Helpop implements CommandExecutor {

    CoolDown cool = new CoolDown(new HashMap<>());

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        boolean zwrot= true;
        if (!(sender instanceof Player)) {
            System.out.println("This command is not for console!");
            return zwrot;
        }
        Player player = (Player)sender;
        String permisja = Main.getInstance().getConfig().getString("permission");
        if (args.length < 1) {
            player.sendMessage(ColorsChat.sendColor(Main.getInstance().getConfig().getString("noarguments")));
            return zwrot;
        }
        if (cool.hasCool(player.getUniqueId(), 5)) {
            long time = cool.czasCool(player.getUniqueId(), 5);
            player.sendMessage(ColorsChat.sendColor(Main.getInstance().getConfig().getString("cooldownMSG").replace("{TIME}", String.valueOf(time))));
            return zwrot;
        }
        cool.setCool(player.getUniqueId());
        String wiadomosc = String.join(" ", args);
        Bukkit.getOnlinePlayers().stream().filter(player1 -> player1.hasPermission(permisja))
                .forEach(player1 -> player1.sendMessage(
                        ColorsChat.sendColor(Main.getInstance()
                                .getConfig().getString("prefix").replace("{MESSAGE}", wiadomosc).replace("{PLAYER}", player.getName())))
                );
        return zwrot;
    }
}
