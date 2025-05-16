package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.WeatherRequest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherbitProvider implements WeatherProvider {

    private static final String API_KEY = "39fc3d1756e4493c994d703aca14941a";

    @Override
    public WeatherData fetch(WeatherRequest request) {
        String city = request.getCity();
        String urlString = "https://api.weatherbit.io/v2.0/current?city=" +
                city + "&key=" + API_KEY;

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
            JSONObject data = obj.getJSONArray("data").getJSONObject(0);
            double temp = data.getDouble("temp");
            String condition = data.getJSONObject("weather").getString("description");

            return new WeatherData(temp, condition);

        } catch (Exception e) {
            System.out.println("Error al consultar Weatherbit: " + e.getMessage());
            return new WeatherData(0.0, "Sin datos");
        }
    }
}
