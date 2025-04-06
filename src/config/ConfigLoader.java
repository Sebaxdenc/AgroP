package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input == null) {
                throw new IOException("Archivo de configuración no encontrado.");
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}