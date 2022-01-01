package com.github.sxp.java.impl;

import com.github.sxp.java.api.startup.CrossPlatformPlugin;
import com.github.sxp.java.impl.error.PluginClasspathException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class PluginLoader {
    public CrossPlatformPlugin[] plugins;

    public PluginLoader(Path path) {
        plugins = loadPlugins(path);
    }
    public PluginLoader(File path) {
        plugins = loadPlugins(path);
    }

    private CrossPlatformPlugin load(@NotNull Path path) throws Exception {
        return load(path.toFile());
    }

    private @Nullable CrossPlatformPlugin load(File file) throws Exception {
        JarFile jar = new JarFile(file);
        Enumeration<? extends ZipEntry> entries = jar.entries();
        InputStream stream = null;
        while(entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().toLowerCase(Locale.ROOT).equals("plugin.json"))
                stream = jar.getInputStream(entry);
        }

        if (stream == null) return null;

        PluginMetaData metaData = GsonHandler.loadMetaData(stream);

        URLClassLoader child = new URLClassLoader(
                new URL[] {file.toURI().toURL()},
                this.getClass().getClassLoader()
        );
        Class<?> classToLoad = Class.forName(metaData.classpath, true, child);
        Object instance = classToLoad.newInstance();
        if (!(instance instanceof CrossPlatformPlugin plugin)) throw new PluginClasspathException(metaData.name);
        plugin.metadata = metaData;
        plugin.onStart();
        return plugin;
    }

    private CrossPlatformPlugin[] loadPlugins(@NotNull Path path) {
        return loadPlugins(path.toFile());
    }

    private CrossPlatformPlugin[] loadPlugins(File dir) {
        if (dir == null) return new CrossPlatformPlugin[] {};
        if (dir.listFiles() == null) return new CrossPlatformPlugin[] {};
        List<CrossPlatformPlugin> plugins = new ArrayList<>();
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.getName().toLowerCase(Locale.ROOT).endsWith(".jar")) {
                try {
                    CrossPlatformPlugin plugin = load(file);
                    if (plugin == null) continue;
                    plugins.add(plugin);
                } catch (Exception ignored) {}
            }
        }
        return plugins.toArray(CrossPlatformPlugin[]::new);
    }
}
