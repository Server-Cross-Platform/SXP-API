package com.github.sxp.java.platform.fabric;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.kotlin.impl.PluginInitializerKt;
import net.fabricmc.api.ModInitializer;

public class InitializeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SxpData.platform = "Fabric";
        PluginInitializerKt.init();
    }
}
