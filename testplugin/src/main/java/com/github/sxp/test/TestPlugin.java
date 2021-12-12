package com.github.sxp.test;

import com.github.sxp.java.api.startup.CrossPlatformPlugin;

public class TestPlugin extends CrossPlatformPlugin {
    @Override
    public void onStart() {
        System.out.println("Plugin loaded!!");
    }

    @Override
    public void onStop() {

    }
}
