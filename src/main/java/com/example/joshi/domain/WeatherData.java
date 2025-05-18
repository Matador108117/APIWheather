package com.example.joshi.domain;

public class WeatherData {
    private double temperature;
    private String condition;
    
    public WeatherData() {
    }

    public WeatherData(double temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Temp: " + temperature + "°C, Condición: " + condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }



}