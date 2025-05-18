package com.example.joshi.gui;

import java.util.Scanner;

import com.example.joshi.domain.LoggerUtil;
import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.factory.WeatherProviderFactory;
import com.example.joshi.logic.WeatherService;
import com.example.joshi.logic.WeatherService.WeatherException;
import com.example.joshi.shared.Messages;


public class Menu {
    private WeatherProviderFactory factory; // implementar inyeccion de dependencias
    private WeatherService serv;

    public Menu() {
        serv = new WeatherService();
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        String providerName = "";

        while (true) {
            providerName = "";
            Messages.INITIAL_MENU.print();
            String city = scanner.nextLine();
            if ("salir".equalsIgnoreCase(city.trim())) {
                break;
            }

            Messages.PROVIDER_MENU.print();
            String providerOption = scanner.nextLine();

            switch (providerOption) {
                case "1" -> providerName = "openweather";
                case "2" -> providerName = "weatherapi";
                case "3" -> providerName = "weatherbit";
                default -> Messages.INVALID_OPTION.print();
            }

            if (!providerName.isEmpty()) {
                try {
                    WeatherData data = serv.getWeather(providerName, city);
                    Messages.RESULT.printWith(data.toString());
                    LoggerUtil.log(city, providerName, data.getTemperature(), data.getCondition());
                    Messages.SEPARATOR.print();
                } catch (WeatherException e) {
                    System.err.println("Error al consultar el clima: " + e.getMessage());
                }
            }
        }
        Messages.END.print();
        scanner.close();
    }
}
