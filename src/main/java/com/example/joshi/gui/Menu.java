package com.example.joshi.gui;

import java.util.Scanner;

import com.example.joshi.domain.LoggerUtil;
import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.builder.WeatherDirector;
import com.example.joshi.domain.singleton.WeatherSingleton;
import com.example.joshi.logic.WheatherService;
import com.example.joshi.shared.Messages;

public class Menu {
    private WeatherDirector director;
    private WheatherService serv;

    public Menu() {
        serv = new WheatherService();
        director = WeatherSingleton.getInstance().getDirector();
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        String providerName;

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
                WeatherData data = serv.selectWheather(city, providerName, director);
                Messages.RESULT.printWith(data.toString());
                LoggerUtil.log(city, providerName, data.getTemperature(), data.getCondition());
                Messages.SEPARATOR.print();
            }
        }

        Messages.END.print();
        scanner.close();
    }
}
