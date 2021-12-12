package com.github.sxp.java.impl;

import com.google.gson.Gson;

import java.io.InputStream;

public class GsonHandler {
    public static Gson gson = new Gson();

    public static PluginMetaData loadMetaData(InputStream json) {
        return PluginMetaData.fromJson(gson,json);
    }
}
