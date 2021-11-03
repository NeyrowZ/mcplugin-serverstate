package net.neyrowz.serverstate.utils;

import net.neyrowz.serverstate.state.StateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerManager {

    public static void kickAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kickPlayer(StateManager.color() + StateManager.msg());
        }
    }

    public static void kickAllIsNotWhitelist() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.isOp() || player.hasPermission("server.maintenance.join")) {
                player.kickPlayer(StateManager.color() + StateManager.msg());
            }
        }
    }
}