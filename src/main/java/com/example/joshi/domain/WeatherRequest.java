package com.example.joshi.domain;

public class WeatherRequest {
    private String city;

    public WeatherRequest(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
