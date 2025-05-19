package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.WeatherbitProvider;
import com.example.joshi.domain.builder.WeatherBuilderInterface;
public class WheaterBitFactory implements WeatherProviderFactory {

    @Override
    public WeatherProvider creaProvider(WeatherBuilderInterface builder) {
        return new WeatherbitProvider(builder);
    }
}