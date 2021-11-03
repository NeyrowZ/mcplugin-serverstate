package net.neyrowz.serverstate;

import net.neyrowz.serverstate.loaders.CommandsLoader;
import net.neyrowz.serverstate.loaders.EventsLoader;
import net.neyrowz.serverstate.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        CommandsLoader.load(instance);
        EventsLoader.load(instance);
        initConfig();

        Bukkit.getConsoleSender().sendMessage("\u001B[36m[ServerState]\u001B[0m net.neyrowz.serverstate.Main - onEnable() plugin is enable.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("\u001B[36m[ServerState]\u001B[0m net.neyrowz.serverstate.Main - onDisable() plugin has been disabled.");
    }

    public void initConfig() {
        Config.initConfig();
        Config.getConfig().addDefault("server.state", "open");
        Config.getConfig().options().copyDefaults(true);
        Config.saveConfig();
    }

    public static Main getInstance() { return instance; }
}