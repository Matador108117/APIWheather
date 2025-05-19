package com.example.joshi.domain;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

import com.example.joshi.domain.builder.WeatherBuilderInterface;

public abstract class WeatherProvider {
    protected  String  apiKey;
    protected String urlString;
    public abstract WeatherData fetch(WeatherRequest request) throws MalformedURLException, IOException, JSONException ;
    
    public WeatherProvider(WeatherBuilderInterface builder){
        this.apiKey = builder.getApiKey();
        this.urlString = builder.getUrlString();
    }
}
