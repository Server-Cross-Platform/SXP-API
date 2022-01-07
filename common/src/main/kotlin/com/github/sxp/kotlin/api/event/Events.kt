package com.github.sxp.kotlin.api.event

import com.github.sxp.java.api.event.EventContext
import com.github.sxp.java.api.event.XEvent

class Events<T:EventContext>(val event: XEvent<T>)
val PLAYER_JOIN = Events<PlayerJoinEvent>(XEvent())