// This code snippet is defining a Java interface named `WeatherBuilderInterface` within the package `com.example.joshi.domain.builder`.
package com.example.joshi.domain.builder;

import com.example.joshi.domain.WeatherProvider;

public interface WeatherBuilderInterface {
    void reset();
    WeatherProvider build();
    WeatherBuilderInterface setApiKey(String apiKey);
    WeatherBuilderInterface setUrlString(String urlString);
    String getApiKey();
    String getUrlString();
    
}
