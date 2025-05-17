package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.WeatherbitProvider;

public class WheaterBitFactory implements WeatherProviderFactory {

    @Override
    public WeatherProvider creaProvider() {
        return new WeatherbitProvider();
    }
}