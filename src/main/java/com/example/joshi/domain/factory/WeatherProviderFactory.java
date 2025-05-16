package com.example.joshi.domain.factory;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.OpenWeatherProvider;
import com.example.joshi.logic.WeatherAPIProvider;
import com.example.joshi.logic.WeatherbitProvider;

public interface WeatherProviderFactory {
    public WeatherProvider creaProvider();
}
