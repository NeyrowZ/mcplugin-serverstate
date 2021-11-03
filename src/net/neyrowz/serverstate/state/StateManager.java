package net.neyrowz.serverstate.state;

import net.neyrowz.serverstate.utils.Config;

public class StateManager {

    public static StateList getState() {
        for (StateList stateList : StateList.values()) {
            if(stateList.getState() == Config.getConfig().get("server.state")) return stateList;
        }
        return StateList.RUNNING;
    }

    public static String state() {
        return getState().getState();
    }

    public static String msg() {
        return getState().getMsg();
    }

    public static String color() {
        return getState().getColor();
    }
}