package com.github.sxp.kotlin.impl

import com.github.sxp.java.impl.PluginLoader
import java.nio.file.Path

lateinit var pluginLoader: PluginLoader
fun init() {
    val pluginPath = Path.of("./XPlugins")
    val pluginFile = pluginPath.toFile()
    if (!pluginFile.exists()) pluginFile.mkdir()
    pluginLoader = PluginLoader(pluginPath)
}
fun close() {
    for (plugin in pluginLoader.plugins) {
        plugin.onStop()
    }
}