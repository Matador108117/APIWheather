package com.example.joshi.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;

public class OpenWeatherProvider implements WeatherProvider {

    private static final String API_KEY = "6f31e30b1b2a09976d3750f22f5a9caf";
    private String city;
    private WeatherData data;
    private JSONObject cachedJson;

    public OpenWeatherProvider(String city) {
        this.city = city;
        reset();
    }

    @Override
    public void reset() {
        data = new WeatherData();
        cachedJson = null;
    }

    @Override
    public void buildTemperature() {
        try {
            JSONObject json = fetchJson();
            double temp = json.getJSONObject("main").getDouble("temp");
            data.setTemperature(temp);
        } catch (Exception e) {
            data.setTemperature(0.0);
        }
    }

    @Override
    public void buildCondition() {
        try {
            JSONObject json = fetchJson();
            String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");
            data.setCondition(condition);
        } catch (Exception e) {
            data.setCondition("Sin datos");
        }
    }

    @Override
    public WeatherData getResult() {
        return data;
    }

    private JSONObject fetchJson() throws Exception {
        if (cachedJson != null) return cachedJson;

        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&appid=" + API_KEY + "&units=metric";

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        con.disconnect();

        cachedJson = new JSONObject(response.toString());
        return cachedJson;
    }
}
