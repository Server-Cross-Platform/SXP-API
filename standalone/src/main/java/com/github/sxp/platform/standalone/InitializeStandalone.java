package com.github.sxp.platform.standalone;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class InitializeStandalone {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        File config = new File("./SXP-config.json");
        McJarLoader loader = new McJarLoader();
        if (config.exists()) {
            loader = gson.fromJson(String.valueOf(new FileInputStream(config)), McJarLoader.class);
        } else {
            var stream = new FileOutputStream(config);
            stream.write(gson.toJson(loader).getBytes(StandardCharsets.UTF_8));
            stream.close();
        }
        Class<?> mcClass = loader.loadMainClass();
        mcClass.getMethod("main", String[].class).invoke(null, (Object) args);
    }
}
