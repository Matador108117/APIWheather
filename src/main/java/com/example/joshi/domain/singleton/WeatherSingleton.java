package com.example.joshi.domain.singleton;

import com.example.joshi.domain.builder.WeatherDirector;

public class WeatherSingleton {

    private static WeatherSingleton instance;
    private final WeatherDirector director;

    
    private WeatherSingleton() {
        director = new WeatherDirector();
    }
   
    public static WeatherSingleton getInstance() {
        if (instance == null) {
            instance = new WeatherSingleton();
        }
        return instance;
    }

    public WeatherDirector getDirector() {
        return director;
    }
}
