package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;

public class WeatherDirector {

    private WeatherProvider builder;

    public WeatherDirector(WeatherProvider builder) {
        this.builder = builder;
    }


    public void construct() {
        builder.reset();
        builder.buildTemperature();
    }

    public WeatherData getResult() {
        return builder.getResult();
    }
}
