package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.WeatherbitProvider;

public class WheaterBitFactory implements WeatherProviderFactory {
    private String city;

    public WheaterBitFactory(String city) {
        this.city = city;
    }

    @Override
    public WeatherProvider creaProvider() {
        return new WeatherbitProvider(city);
    }
}