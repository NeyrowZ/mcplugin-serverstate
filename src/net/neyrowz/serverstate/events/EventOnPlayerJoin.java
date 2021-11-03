package net.neyrowz.serverstate.events;

import net.neyrowz.serverstate.state.StateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventOnPlayerJoin implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        switch (StateManager.state()) {
            case "maintenance" -> {
                if (player.isOp() || player.hasPermission("server.maintenance.join")) {
                    player.kickPlayer(StateManager.color() + StateManager.msg());
                }
            }
            case "close" -> {
                player.kickPlayer(StateManager.color() + StateManager.msg());
            }
        }
    }
}