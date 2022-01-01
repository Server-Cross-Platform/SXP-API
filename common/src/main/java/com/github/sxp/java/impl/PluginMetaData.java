package com.github.sxp.java.impl;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PluginMetaData {
    public String name = "";
    public String description = "";
    public String[] authors = {};
    public String classpath = "";

    public PluginMetaData() {}

    public String toJson(Gson gson) {
        return gson.toJson(this);
    }
    public static PluginMetaData fromJson(Gson gson, InputStream json) {
        return gson.fromJson(new InputStreamReader(json),PluginMetaData.class);
    }
}