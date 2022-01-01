package com.github.sxp.platform.standalone;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class McJarLoader {
    public String jarPath = "./server.jar";

    public McJarLoader() {

    }

    public Class<?> loadMainClass() throws Exception {
        var file = new File(jarPath);
        JarFile jar = new JarFile(file);
        URLClassLoader child = new URLClassLoader(
                new URL[] {file.toURI().toURL()},
                this.getClass().getClassLoader()
        );
        Class<?> mcClass = Class.forName("net.minecraft.bundler.Main", true, child);
        return mcClass;
    }
}
