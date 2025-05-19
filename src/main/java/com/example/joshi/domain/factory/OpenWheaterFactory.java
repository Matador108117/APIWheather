package com.example.joshi.domain.factory;
import com.example.joshi.logic.OpenWeatherProvider;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.builder.WeatherBuilderInterface;

public class OpenWheaterFactory implements WeatherProviderFactory {
    @Override
    public WeatherProvider creaProvider(WeatherBuilderInterface builder) {
        return new OpenWeatherProvider(builder);
    }
    
}
