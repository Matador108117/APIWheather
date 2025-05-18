package com.example.joshi.domain.factory;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.logic.OpenWeatherProvider;

public class OpenWheaterFactory implements WeatherProviderFactory {
    private String city;

    public OpenWheaterFactory(String city) {
        this.city = city;
    }

    @Override
    public WeatherProvider creaProvider() {
        return new OpenWeatherProvider(city);
    }
}
