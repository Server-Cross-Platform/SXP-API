package com.github.sxp.platform.forge;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.java.impl.PluginLoader;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.nio.file.Path;

@Mod("SXP-API")
public class InitializeForge {
    public static PluginLoader pluginLoader;

    public InitializeForge() {
        SxpData.platform = "forge";

    }

    public static void initPlugins() {
        Path pluginPath = Path.of("./XPlugins");
        File pluginFile = pluginPath.toFile();
        if (!pluginFile.exists())
            pluginFile.mkdir();
        pluginLoader = new PluginLoader(pluginPath);
    }
}
