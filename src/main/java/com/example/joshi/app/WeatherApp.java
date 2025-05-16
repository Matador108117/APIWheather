package com.example.joshi.app;
import java.util.Scanner;
import com.example.joshi.domain.WeatherRequest;
import com.example.joshi.domain.factory.WeatherProviderFactory;
import com.example.joshi.domain.WeatherProvider;
import com.example.joshi.domain.WeatherData;
import com.example.joshi.domain.LoggerUtil;
public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Consulta de Clima ===");

        while (true) {
            System.out.print("Ingresa el nombre de la ciudad (o 'salir' para terminar): ");
            String city = scanner.nextLine();

            if (city.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Elige el proveedor de clima:");
            System.out.println("1. OpenWeather");
            System.out.println("2. WeatherAPI");
            System.out.println("3. Weatherbit");
            System.out.print("Opción: ");
            String option = scanner.nextLine();

            String providerName = "";
            switch (option) {
                case "1":
                    providerName = "openweather";
                    break;
                case "2":
                    providerName = "weatherapi";
                    break;
                case "3":
                    providerName = "weatherbit";
                    break;
                default:
                    System.out.println("Opción no válida");
                    continue;
            }

            WeatherRequest request = new WeatherRequest(city);
            WeatherProvider provider = WeatherProviderFactory.getProvider(providerName);
            WeatherData data = provider.fetch(request);

            System.out.println("Resultado: " + data);
            LoggerUtil.log(city, providerName, data.getTemperature(), data.getCondition());
            System.out.println("----------------------------");
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
