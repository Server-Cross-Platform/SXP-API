package com.github.sxp.java.impl;

import com.github.sxp.java.api.startup.CrossPlatformPlugin;
import com.github.sxp.java.impl.error.PluginClasspathException;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Locale;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;


//Some cursed as fuck classloading...
public class PluginLoader {
    public CrossPlatformPlugin load(Path path) throws Exception {
        return load(path.toFile());
    }

    public CrossPlatformPlugin load(File file) throws Exception {
        JarFile jar = new JarFile(file);
        Enumeration<? extends ZipEntry> entries = jar.entries();
        InputStream stream = null;
        while(entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().toLowerCase(Locale.ROOT).equals("plugin.json"))
                stream = jar.getInputStream(entry);
        }

        if (stream == null) return null;

        String text = new BufferedReader(
                new InputStreamReader(stream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        PluginMetaData metaData = GsonHandler.loadMetaData(text);

        URLClassLoader child = new URLClassLoader(
                new URL[] {file.toURI().toURL()},
                this.getClass().getClassLoader()
        );
        Class<?> classToLoad = Class.forName(metaData.classpath, true, child);
        Object instance = classToLoad.newInstance();
        if (!(instance instanceof CrossPlatformPlugin plugin)) throw new PluginClasspathException(metaData.name);
        plugin.onStart();
        return plugin;
    }
}
