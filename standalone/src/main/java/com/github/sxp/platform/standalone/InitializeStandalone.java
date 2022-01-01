package com.github.sxp.platform.standalone;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InitializeStandalone {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        File config = new File("./SXP-config.json");
        McJarLoader loader = new McJarLoader();
        if (config.exists()) {
            var stream = new FileInputStream(config);
            loader = gson.fromJson(new InputStreamReader(stream), McJarLoader.class);
            stream.close();
        } else {
            var stream = new FileOutputStream(config);
            stream.write(gson.toJson(loader).getBytes(StandardCharsets.UTF_8));
            stream.close();
        }
        Class<?> mcClass = loader.loadMainClass();
        mcClass.getMethod("main", String[].class).invoke(null, (Object) args);
    }
}
