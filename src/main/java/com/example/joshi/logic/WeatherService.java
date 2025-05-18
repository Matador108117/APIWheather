package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;




public class WeatherService {
    public static class WeatherException extends Exception {
        public WeatherException(String message) {
            super(message);
        }
        public WeatherException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ProviderUnavailableException extends WeatherException {
        public ProviderUnavailableException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    public WeatherData getWeather(String providerName, String city) throws WeatherException {
        WeatherProvider builder;
        

        switch(providerName.toLowerCase()) {
            case "openweather":
                builder = new OpenWeatherProvider(city);
                break;
            case "weatherapi":
                builder = new WeatherAPIProvider(city);
                break;
            case "weatherbit":
                builder = new WeatherbitProvider(city);
                break;
            default:
                throw new WeatherException("Proveedor desconocido: " + providerName);
        }

        WeatherDirector director = new WeatherDirector(builder);

        try {
            director.construct();
            return director.getResult();
        } catch (Exception e) {
            throw new ProviderUnavailableException("Error obteniendo datos del proveedor ", e);
        }
    }
        
        
    }

