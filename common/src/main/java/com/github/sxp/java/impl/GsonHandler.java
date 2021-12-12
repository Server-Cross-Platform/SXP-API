package com.github.sxp.java.impl;

import com.google.gson.Gson;

public class GsonHandler {
    public static Gson gson = new Gson();

    public static PluginMetaData loadMetaData(String json) {
        return PluginMetaData.fromJson(gson,json);
    }
}
