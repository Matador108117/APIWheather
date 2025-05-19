package com.example.joshi.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.example.joshi.shared.Messages;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (input == null) {
                System.out.println(Messages.NOT_FOND_APP_PROPERTIES.get());
            } else {
                properties.load(input);
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
