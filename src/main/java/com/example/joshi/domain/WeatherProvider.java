package com.example.joshi.domain;

public interface WeatherProvider {
    WeatherData fetch(WeatherRequest request);
}
