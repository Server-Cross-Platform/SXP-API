package com.github.sxp.java.impl;

import com.google.gson.Gson;

public class PluginMetaData {
    public String name = "";
    public String description = "";
    public String[] authors = {};
    public String classpath = "";

    public PluginMetaData() {}

    public String toJson(Gson gson) {
        return gson.toJson(this);
    }
    public static PluginMetaData fromJson(Gson gson, String json) {
        return gson.fromJson(json,PluginMetaData.class);
    }
}
