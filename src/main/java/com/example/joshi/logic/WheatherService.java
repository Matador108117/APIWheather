package com.example.joshi.logic;
import com.example.joshi.domain.WeatherRequest;
import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.builder.WeatherDirector;
import com.example.joshi.shared.Messages;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;

/**
 * WeatherService class responsible for selecting the appropriate weather provider
 * and fetching the weather data. Handles various exceptions with descriptive messages.
 */
public class WheatherService {

    /**
     * Fetches weather data from the selected provider.
     *
     * @param city          Name of the city to fetch weather for
     * @param providerName  Name of the provider (e.g., "openweather")
     * @param director      Director that constructs weather providers
     * @return              WeatherData object with fetched weather info
     */
    public WeatherData selectWheather(String city, String providerName, WeatherDirector director) {
        WeatherRequest request = new WeatherRequest(city);

        try {
            return switch (providerName) {
                case "openweather" -> director.constructOpenWeather().fetch(request);
                case "weatherapi" -> director.constructWeatherAPI().fetch(request);
                case "weatherbit" -> director.constructWeatherBit().fetch(request);
                default -> {
                    Messages.INVALID_OPTION.print();
                    yield new WeatherData(0.0, "sin datos");
                }
            };
        } catch (MalformedURLException e) {
            Messages.ERROR_INVALID_URL.printWith(" Detalles: " + e.getMessage());
        } catch (IOException e) {
            Messages.ERROR_CONNECTION.printWith(" Detalles: " + e.getMessage());
        } catch (JSONException e) {
            Messages.ERROR_JSON_PARSE.printWith(" Detalles: " + e.getMessage());
        } catch (Exception e) {
            Messages.ERROR_UNEXPECTED.printWith(" Detalles: " + e.getMessage());
        }

        return new WeatherData(0.0, "sin datos");
    }
}
