package com.github.sxp.java.api.config;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Configuration {
    private static Gson gson = new Gson();

    public Path getConfigDir() {
        return Path.of("./config");
    }

    public <T> T loadJson(Class<T> outputClass, File file) {
        if (file.isDirectory() || !file.canRead()) return null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (Exception e) {
            return null;
        }
        return gson.fromJson(String.valueOf(stream),outputClass);
    }

    public <T> void saveJson(T obj, File file) {
        String s = gson.toJson(obj);
        if (file.isDirectory() || !file.canWrite()) return;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            new FileOutputStream(file).write(s.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ignored) {}
    }
}
