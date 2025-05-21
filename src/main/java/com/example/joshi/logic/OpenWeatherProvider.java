package com.example.joshi.logic;

import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.WeatherRequest;
import com.example.joshi.domain.builder.WeatherBuilderInterface;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

public class OpenWeatherProvider extends WeatherProvider {
    public OpenWeatherProvider( WeatherBuilderInterface builder) {
        super(builder);
    }

    @Override
    public WeatherData fetch(WeatherRequest request) throws MalformedURLException, IOException, JSONException {
        String cleanCity = request.getCity().replace(" ", "");
        String urlString = this.urlString +
                "q="+ cleanCity + "&appid=" + this.apiKey + "&units=metric";
        
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

    }
}
