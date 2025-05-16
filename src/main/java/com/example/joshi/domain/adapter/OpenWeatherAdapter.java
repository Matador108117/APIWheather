package com.example.joshi.domain.adapter;

import com.example.joshi.domain.WeatherRequest;

public class OpenWeatherAdapter {
    private String formattedQuery;

    public OpenWeatherAdapter(WeatherRequest request) {
        this.formattedQuery = "q=" + request.getCity();
    }

    public String getFormattedQuery() {
        return formattedQuery;
    }
}
