package com.github.sxp.kotlin.impl

import com.github.sxp.java.impl.PluginLoader
import java.nio.file.Path

var pluginLoader: PluginLoader = TODO()
fun init() {
    val pluginPath = Path.of("./XPlugins")
    val pluginFile = pluginPath.toFile()
    if (!pluginFile.exists()) pluginFile.mkdir()
    pluginLoader = PluginLoader(pluginPath)
}