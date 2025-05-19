package com.example.joshi.domain.builder;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.ConfigLoader;

public class WeatherDirector {

    public WeatherProvider constructWeatherBit() {
    return  new WeatherBitBuilder()
        .setApiKey(ConfigLoader.get("weather.bit.key"))
        .setUrlString(ConfigLoader.get("weather.bit.url"))
        .build();
    }

    public WeatherProvider constructOpenWeather() {
    return new WeatherOpenBuilder()
        .setApiKey(ConfigLoader.get("openweather.api.key"))
        .setUrlString(ConfigLoader.get("openweather.api.url"))
        .build();
    }

    public WeatherProvider constructWeatherAPI() {
        return new WeatherAPIBuilder()
            .setApiKey(ConfigLoader.get("weather.api.key"))
            .setUrlString(ConfigLoader.get("weather.api.url"))
            .build();
    }
}
