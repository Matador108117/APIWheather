package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.WeatherRequest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherAPIProvider implements WeatherProvider {

    private static final String API_KEY = "2e230c713ce141da92a200650251205";

    @Override
    public WeatherData fetch(WeatherRequest request) {
        String city = request.getCity();
        String urlString = "https://api.weatherapi.com/v1/current.json?key=" +
                API_KEY + "&q=" + city;

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
            double temp = obj.getJSONObject("current").getDouble("temp_c");
            String condition = obj.getJSONObject("current").getJSONObject("condition").getString("text");

            return new WeatherData(temp, condition);

        } catch (Exception e) {
            System.out.println("Error al consultar WeatherAPI: " + e.getMessage());
            return new WeatherData(0.0, "Sin datos");
        }
    }
}
