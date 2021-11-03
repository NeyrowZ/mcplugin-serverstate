package net.neyrowz.serverstate.loaders;

import net.neyrowz.serverstate.Main;
import net.neyrowz.serverstate.commands.CommandServerState;

public class CommandsLoader {

    public static void load(Main plugin) {
        plugin.getCommand("serverstate").setExecutor(new CommandServerState());
    }
}
