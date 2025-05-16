package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.WeatherRequest;
import com.example.joshi.domain.adapter.OpenWeatherAdapter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class OpenWeatherProvider implements WeatherProvider {

    private static final String API_KEY = "6f31e30b1b2a09976d3750f22f5a9caf";

    @Override
    public WeatherData fetch(WeatherRequest request) {
        OpenWeatherAdapter adapter = new OpenWeatherAdapter(request);
        String query = adapter.getFormattedQuery();

        String urlString = "https://api.openweathermap.org/data/2.5/weather?" +
                query + "&appid=" + API_KEY + "&units=metric";

        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            JSONObject obj = new JSONObject(content.toString());
            double temp = obj.getJSONObject("main").getDouble("temp");
            String condition = obj.getJSONArray("weather").getJSONObject(0).getString("description");

            return new WeatherData(temp, condition);

        } catch (Exception e) {
            System.out.println("Error al consultar OpenWeather: " + e.getMessage());
            return new WeatherData(0.0, "Sin datos");
        }
    }
}
