package com.example.joshi.domain.builder;

import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.factory.OpenWheaterFactory;

public class WeatherOpenBuilder implements WeatherBuilderInterface {
    private String apiKey;
    private String urlString;

    @Override
    public WeatherProvider build() {

        return new OpenWheaterFactory().creaProvider(this);
    }

    @Override
    public String getApiKey() {

        return this.apiKey;
    }

    @Override
    public String getUrlString() {
        return this.urlString;
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

}
