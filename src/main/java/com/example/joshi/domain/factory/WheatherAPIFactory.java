package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.WeatherAPIProvider;

public class WheatherAPIFactory implements WeatherProviderFactory {
    private String city;

    public WheatherAPIFactory(String city) {
        this.city = city;
    }

    @Override
    public WeatherProvider creaProvider() {
        return new WeatherAPIProvider(city);
    }
}
