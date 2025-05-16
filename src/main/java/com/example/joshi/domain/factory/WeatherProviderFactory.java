package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.OpenWeatherProvider;
import com.example.joshi.logic.WeatherAPIProvider;
import com.example.joshi.logic.WeatherbitProvider;

public class WeatherProviderFactory {
    public static WeatherProvider getProvider(String providerName) {
        return switch (providerName.toLowerCase()) {
            case "openweather" -> new OpenWeatherProvider();
            case "weatherapi" -> new WeatherAPIProvider();
            case "weatherbit" -> new WeatherbitProvider();
            default -> throw new IllegalArgumentException("Proveedor no válido");
        };
    }
}
