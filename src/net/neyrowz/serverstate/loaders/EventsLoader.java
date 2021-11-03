package net.neyrowz.serverstate.loaders;

import net.neyrowz.serverstate.Main;
import net.neyrowz.serverstate.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsLoader {
    public static void load(Main plugin) {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new EventOnPlayerJoin(), plugin);
    }
}
