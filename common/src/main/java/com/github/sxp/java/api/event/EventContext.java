package com.github.sxp.java.api.event;

public class EventContext {
    private final String name;
    private final int id;
    public EventContext(String eventName, int eventId) {
        name = eventName;
        id = eventId;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
