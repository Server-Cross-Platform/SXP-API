package com.github.sxp.kotlin.api.event

import com.github.sxp.java.api.event.EventContext
import com.github.sxp.java.api.event.XEvent
import java.util.function.Consumer

class Events<T:EventContext>(val event: XEvent<T>) {
    fun register(consumer: Consumer<T>) {
        event.addListener(consumer)
    }
    fun execute(ctx: T) {
        event.trigger(ctx)
    }
}
val PLAYER_JOIN = Events<PlayerJoinEvent>(XEvent())