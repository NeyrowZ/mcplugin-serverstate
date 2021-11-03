package net.neyrowz.serverstate.utils;

import net.neyrowz.serverstate.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file;
    private static FileConfiguration config;

    public static Main plugin = Main.getInstance();

    public static void initConfig() {
        file = new File(plugin.getDataFolder(), "serverState.yml");

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void set(String path, String value) {
        config.set(path, value);
        saveConfig();
    }

    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

//    public static void initWhitelist() {
//        config.set("server.whitelist", getWhitelist());
//        saveConfig();
//    }
//
//    public static List<String> getWhitelist() {
//        return whitelist;
//    }
}