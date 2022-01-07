package com.github.sxp.platform.fabric;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.kotlin.impl.PluginInitializerKt;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class InitializeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SxpData.platform = "Fabric";
        PluginInitializerKt.init();
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            PluginInitializerKt.close();
        });
    }
}
