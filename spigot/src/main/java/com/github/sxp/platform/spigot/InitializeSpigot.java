package com.github.sxp.platform.spigot;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.kotlin.impl.PluginInitializerKt;
import org.bukkit.plugin.java.JavaPlugin;

public class InitializeSpigot extends JavaPlugin {
    @Override
    public void onLoad() {
        SxpData.platform = "Spigot";
        PluginInitializerKt.init();
    }
}
