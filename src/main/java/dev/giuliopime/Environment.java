package dev.giuliopime;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Environment {
    private static Environment instance;
    private Dotenv dotenv;

    public static String GEOLOCATION_API_KEY = null;

    public static Environment getInstance() {
        if (instance == null)
            instance = new Environment();

        return instance;
    }

    private Environment() {
        dotenv = Dotenv.load();

        GEOLOCATION_API_KEY = getValore("GEOLOCATION_API_KEY");
    }

    public String getValore(String chiave) {
        String valore = null;

        try {
            valore = dotenv.get(chiave);
        } catch (Exception e) {
            System.out.println("Non è stata trovata la chiave " + chiave + " nel file .env");
            System.exit(404);
        }

        return valore;
    }
}
