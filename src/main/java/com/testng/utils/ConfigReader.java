package com.testng.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    //This class is used to read properties file
    private static Properties prop;
    private ConfigReader() {}

    public static void loadProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream file = new FileInputStream("src/test/resources/config/Configuration.properties");
                prop.load(file);
            } catch (IOException e) {
                throw new RuntimeException("Could not load Configuration.properties from src/main/config", e);
            }
        }
    }
    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }
}
