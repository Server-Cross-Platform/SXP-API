package com.github.sxp.java.platform.fabric;

import com.github.sxp.java.impl.PluginLoader;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.nio.file.Path;

public class FabricPluginLoader {
    public static PluginLoader pluginLoader;

    public static void initPlugins(MinecraftServer server) {
        Path pluginPath = FabricLoader.getInstance().getGameDir().resolve("XPlugins");
        File pluginFile = pluginPath.toFile();
        if (!pluginFile.exists())
            pluginFile.mkdir();
        pluginLoader = new PluginLoader(pluginPath);
    }
}
