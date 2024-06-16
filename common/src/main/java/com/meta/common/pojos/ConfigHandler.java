package com.meta.common.pojos;

import com.meta.util.json.Json;

/**
 * @author Yuvraj Singh
 */
public class ConfigHandler {

    public static Config getFromJson(String jsonConfig) {
        Config config = null;
        try {
            var json = Json.create();
            config = json.decode(jsonConfig, Config.class);
        } catch (Exception e) {
            System.out.println("Error in reading config: " + e.getMessage());
        }
        return config;
    }
}
