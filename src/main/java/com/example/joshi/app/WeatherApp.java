package com.example.joshi.app;

import com.example.joshi.gui.Menu;
import com.example.joshi.domain.singleton.WeatherSingleton;
public class WeatherApp {
    public static void main(String[] args) {
    WeatherSingleton singleton = WeatherSingleton.getInstance();
    Menu menu = new Menu(singleton);
    menu.startMenu();
    }
}
