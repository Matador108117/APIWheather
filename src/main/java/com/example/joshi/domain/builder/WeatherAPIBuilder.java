package com.example.joshi.domain.builder;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.factory.WheatherAPIFactory;

public class WeatherAPIBuilder implements WeatherBuilderInterface {
    private String apiKey;
    private String urlString;

    @Override
    public WeatherProvider build() {

        return new WheatherAPIFactory().creaProvider(this);
    }

    @Override
    public void reset() {
        this.apiKey = "";
        this.urlString = "";
    }

    @Override
    public WeatherBuilderInterface setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;

    }

    @Override
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
