package dev.giuliopime;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Environment {
    private static Environment instance;
    private Dotenv dotenv;

    public static String ERROR_FILE = "index.html?error=true";
    public static String SUCCESS_FILE = "nome.jsp";

    public static Environment getInstance() {
        if (instance == null)
            instance = new Environment();

        return instance;
    }

    private Environment() {
        /*
        Il file .env non viene caricato correttamente
        dotenv = Dotenv.load();

        ERROR_FILE = getValore("ERROR_FILE");
        SUCCESS_FILE = getValore("SUCCESS_FILE");
         */

        System.out.println("Environment");
        System.out.println("ERROR_FILE: " + ERROR_FILE);
        System.out.println("SUCCESS_FILE: " + SUCCESS_FILE);
    }

    /**
     * Prende un valore dal file .env
     * @param chiave il nome del valore
     * @return Il valore
     */
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
