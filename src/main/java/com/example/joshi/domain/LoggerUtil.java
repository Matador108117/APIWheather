package com.example.joshi.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String FILE_NAME = "log.txt";

    public static void log(String city, String provider, double temp, String condition) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            String logEntry = String.format("[%s] Ciudad: %s | Proveedor: %s | Temp: %.1f°C | Condición: %s%n",
                    LocalDateTime.now(), city, provider, temp, condition);
            writer.write(logEntry);
        } catch (IOException e) {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
