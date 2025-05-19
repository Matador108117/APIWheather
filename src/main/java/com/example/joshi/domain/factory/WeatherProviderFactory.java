package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.builder.WeatherBuilderInterface;
public interface WeatherProviderFactory {
    public WeatherProvider creaProvider(WeatherBuilderInterface builder);
}
