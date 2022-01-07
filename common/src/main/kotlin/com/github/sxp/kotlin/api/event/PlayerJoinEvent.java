package com.github.sxp.kotlin.api.event;

import com.github.sxp.java.api.event.EventContext;

public class PlayerJoinEvent extends EventContext {
    public PlayerJoinEvent() {
        super("Player Join", 0);
    }
}
