package com.example.joshi.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;

public class WeatherbitProvider implements WeatherProvider {

    private static final String API_KEY = "39fc3d1756e4493c994d703aca14941a";
    private String city;
    private WeatherData data;
    private JSONObject cachedJson;

    public WeatherbitProvider(String city) {
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
            double temp = json.getJSONArray("data").getJSONObject(0).getDouble("temp");
            data.setTemperature(temp);
        } catch (Exception e) {
            data.setTemperature(0.0);
        }
    }

    @Override
    public void buildCondition() {
        try {
            JSONObject json = fetchJson();
            String condition = json.getJSONArray("data").getJSONObject(0)
                                   .getJSONObject("weather").getString("description");
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

        String urlString = "https://api.weatherbit.io/v2.0/current?city=" +
                city + "&key=" + API_KEY;

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        cachedJson = new JSONObject(content.toString());
        return cachedJson;
    }
}