package com.example.joshi.logic;

import com.example.joshi.domain.WeatherRequest;
import com.example.joshi.domain.factory.OpenWheaterFactory;
import com.example.joshi.domain.factory.WeatherProviderFactory;
import com.example.joshi.domain.factory.WheaterBitFactory;
import com.example.joshi.domain.factory.WheatherAPIFactory;
import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;

public class WheatherService {
    public WeatherData selectWheather(String city, String providerName, WeatherProviderFactory factory) {
        WeatherRequest request = new WeatherRequest(city);
        switch (providerName) {
            case "openweather":
                factory = new OpenWheaterFactory();
                break;
            case "weatherapi":
                factory = new WheatherAPIFactory();
                break;
            case "weatherbit":
                factory = new WheaterBitFactory();
                break;
            default:
                break;
        }

        WeatherProvider provider = factory.creaProvider();

        return provider.fetch(request);
    }

}
