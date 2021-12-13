package com.github.sxp.platform.spigot;

import com.github.sxp.java.impl.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Path;

public class InitializeSpigot extends JavaPlugin {
    public static PluginLoader pluginLoader;
    @Override
    public void onEnable() {
        getServer().getWorldContainer();
    }

    @Override
    public void onDisable() {
    }

    public void initPlugins() {
        Path pluginPath = getServer().getWorldContainer().toPath().resolve("XPlugins");
        File pluginFile = pluginPath.toFile();
        if (!pluginFile.exists())
            pluginFile.mkdir();
        pluginLoader = new PluginLoader(pluginPath);
    }
}
