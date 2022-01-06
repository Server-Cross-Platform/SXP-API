package com.github.sxp.platform.forge;

import com.github.sxp.java.api.SxpData;
import com.github.sxp.kotlin.impl.PluginInitializerKt;
import net.minecraftforge.fml.common.Mod;

@Mod("SXP-API")
public class InitializeForge {
    public InitializeForge() {
        SxpData.platform = "forge";
        PluginInitializerKt.init();
    }
}
