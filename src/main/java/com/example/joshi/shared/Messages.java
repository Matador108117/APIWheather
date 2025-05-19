package com.example.joshi.shared;

public enum Messages {
    INITIAL_MENU("""
            === Consulta de Clima ===
            Ingresa el nombre de la ciudad (o 'salir' para terminar):
            """),
    PROVIDER_MENU("""
            Elige el proveedor de clima:
            1. OpenWeather
            2. WeatherAPI
            3. Weatherbit
            Opción:
            """),
    INVALID_OPTION("Opción no válida"),
    RESULT("Resultado: "),
    SEPARATOR("----------------------------"),
    END("Programa finalizado."),
    ERROR_INVALID_URL("La URL proporcionada es inválida."),
    ERROR_CONNECTION("No se pudo establecer conexión con el servicio climático."),
    ERROR_JSON_PARSE("Error al interpretar la respuesta JSON del proveedor."),
    ERROR_UNEXPECTED("Ha ocurrido un error inesperado."),
    NOT_FOND_APP_PROPERTIES("No se encontro el archivo app.properties"),;


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }

    public void printWith(String suffix) {
        System.out.println(message + suffix);
    }

    public String get() {
        return message;
    }
}
