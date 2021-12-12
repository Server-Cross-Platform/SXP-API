package com.github.sxp.java.api.startup;

import com.github.sxp.java.impl.PluginMetaData;

/**
 * The initializer interface for cross platform plugins
 **/
public abstract class CrossPlatformPlugin {
    /**
     * Plugin's metadata
     * <p>
     * See: {@link com.github.sxp.java.impl.PluginMetaData}
     **/
    public PluginMetaData metadata;

    /**
     * Method called when server finished loading
     **/
    public abstract void onStart();

    /**
     * Method called when server stops
     **/
    public abstract void onStop();

}
