package net.neyrowz.serverstate.commands;

import net.neyrowz.serverstate.utils.Config;
import net.neyrowz.serverstate.utils.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandServerState implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp() && !player.hasPermission("serverstate.*")) return false;
        }
        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "open" -> {
                    sender.sendMessage("§eServerState §6§l>> §8From §e" + Config.getConfig().get("server.state") + " §8to §eopen§8.");
                    Config.set("server.state", "open");
                }
                case "maintenance" -> {
                    sender.sendMessage("§eServerState §6§l>> §8From §e" + Config.getConfig().get("server.state") + " §8to §emaintenance§8.");
                    Config.set("server.state", "maintenance");
                    PlayerManager.kickAllIsNotWhitelist();
                }
                case "close" -> {
                    sender.sendMessage("§eServerState §6§l>> §8From §e" + Config.getConfig().get("server.state") + " §8to §eclose§8.");
                    Config.set("server.state", "close");
                    PlayerManager.kickAll();
                }
                default -> sender.sendMessage("§eServerState §6§l>> §cThe state §e" + args[0].toLowerCase() + " §cdo not exist.");
            }
        }
        return false;
    }
}