package com.example.joshi.domain.factory;
import com.example.joshi.logic.OpenWeatherProvider;
import com.example.joshi.domain.WeatherProvider;

public class OpenWheaterFactory implements WeatherProviderFactory {
    @Override
    public WeatherProvider creaProvider() {
        return new OpenWeatherProvider();
    }
    
}
