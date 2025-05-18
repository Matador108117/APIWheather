package com.example.joshi.domain;

public interface WeatherProvider {
    void reset();
    void buildTemperature();
    void buildCondition();
    WeatherData getResult();
}