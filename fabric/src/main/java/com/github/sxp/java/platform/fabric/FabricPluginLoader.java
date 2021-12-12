package com.github.sxp.java.platform.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;

import java.nio.file.Path;

public class FabricPluginLoader {

    public static void initPlugins(MinecraftServer server) {
        Path pluginPath = FabricLoader.getInstance().getGameDir().resolve("XPlugins");
        System.out.println(pluginPath);
    }
}
