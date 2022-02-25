package rCode.help;

import org.bukkit.plugin.java.JavaPlugin;
import rCode.help.cmd.Helpop;
import rCode.help.util.CheckUpdate;
import rCode.help.util.ColorsChat;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        getLogger().log(Level.INFO, ColorsChat.sendColor("&arHelpop enabled!"));
        CheckUpdate.start();
        getCommand("helpop").setExecutor(new Helpop());
    }


    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().log(Level.INFO, ColorsChat.sendColor("&crHelpop disabled!"));
    }


    public static Main getInstance() {
        return Main.getPlugin(Main.class);
    }


}
