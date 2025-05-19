package com.example.joshi.domain.builder;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.factory.WheaterBitFactory;

public class WeatherBitBuilder implements WeatherBuilderInterface {
    private String apiKey;
    private String urlString;

    public WeatherBitBuilder() {
        reset();
    }

    public void reset() {
        this.apiKey = "";
        this.urlString = "";
    }

    @Override
    public WeatherProvider build() {
        return new WheaterBitFactory().creaProvider(this);
        
    }

    public WeatherBuilderInterface setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public WeatherBuilderInterface setUrlString(String urlString) {
        this.urlString = urlString;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUrlString() {
        return urlString;
    }
    
}
