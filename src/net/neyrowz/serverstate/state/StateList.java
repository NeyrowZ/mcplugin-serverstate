package net.neyrowz.serverstate.state;

public enum StateList {

    DOWN("Server is down for a while", "§4", "close"),
    MAINTENANCE("Server is under Maintenance", "§6", "maintenance"),
    RUNNING("", "", "open");

    private final String msg;
    private final String color;
    private final String state;

    StateList(String msg, String color, String state) {

        this.msg = msg;
        this.color = color;
        this.state = state;
    }

    public final String getMsg() {
        return msg;
    }

    public final String getColor() {
        return color;
    }

    public final String getState() {
        return state;
    }
}