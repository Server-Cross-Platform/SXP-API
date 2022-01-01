package com.github.sxp.java.platform.fabric;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.java.impl.PluginLoader;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.nio.file.Path;

public class InitializeFabric implements ModInitializer {
    public static PluginLoader pluginLoader;
    @Override
    public void onInitialize() {
        SxpData.platform = "Fabric";
        initPlugins();
    }

    public void initPlugins() {
        Path pluginPath = FabricLoader.getInstance().getGameDir().resolve("XPlugins");
        File pluginFile = pluginPath.toFile();
        if (!pluginFile.exists())
            pluginFile.mkdir();
        pluginLoader = new PluginLoader(pluginPath);
    }
}
