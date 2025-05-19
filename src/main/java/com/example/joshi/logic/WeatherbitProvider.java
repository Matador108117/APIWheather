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

public class WeatherbitProvider extends WeatherProvider {
    
    /**
     * Constructs a WeatherbitProvider using a weather builder.
     *
     * @param builder the builder to construct weather data
     */
    public WeatherbitProvider(WeatherBuilderInterface builder) {
        super(builder);
    }
     /**
     * Fetches weather data for a given city from the Weatherbit API.
     *
     * @param request the weather request containing the city
     * @return the weather data including temperature and condition
     * @throws MalformedURLException if the URL is malformed
     * @throws IOException if there is a problem with the HTTP connection
     * @throws JSONException if the JSON response cannot be parsed
     */
    @Override
    
    public WeatherData fetch(WeatherRequest request) throws MalformedURLException, IOException, JSONException  {
        String city = request.getCity();
        String urlString = this.urlString +
                city + "&key=" + this.apiKey;
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
       
    }
}