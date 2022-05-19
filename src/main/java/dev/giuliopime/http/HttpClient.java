package dev.giuliopime.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe generica per la gestione di un client http
 */
public abstract class HttpClient {
    /**
     * Il client che eseguirà le richieste http
     */
    java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
    /**
     * L'Uri delle API
     */
    protected String uri;

    /**
     * Consente di convertire una stringa in una classe java deserializzandola
     */
    protected ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.INDENT_OUTPUT);

    protected HttpClient() {
        setUri();
    }

    /**
     * Metodo generico per effettuare una richiesta http indipendentemente dal tipo di risposta.
     * Andrà specificato il tipo di risposta che si ottiene dalla richiesta attraverso la classe java corrispondente.
     * Utilizza come uri quello ottenuto da {@link #getUriWithQuery(String, String)}.
     * @param queryParam il nome del parametro della query (esempio: name)
     * @param queryValue il valore del parametro della query (esempio: giulio)
     * @param type La classe java che rappresenta la risposta che si vuole ottenere (esempio: Bean.class)
     * @return La classe indicata nel parametro type
     * @throws UnknownError In caso la risposta delle api non coincida con la classe specificata
     */
    protected <T> T get(String queryParam, String queryValue, Class<T> type) throws UnknownError {
       try {
           URI uriWithQuery = new URI(getUriWithQuery(queryParam, queryValue));

           HttpRequest request = HttpRequest.newBuilder()
                   .uri(uriWithQuery)
                   .GET()
                   .build();

           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

           return objectMapper.readValue(response.body(), type);
       } catch (IOException | InterruptedException | URISyntaxException e) {
           System.out.println("Errore nell'effettuare una richiesta http");
           System.out.println(e);
           throw new UnknownError("Errore nella richiesta http");
       }
    }

    /**
     * Imposta l'uri builder a seconda dell'indirizzo delle api da richiamare
     */
    protected abstract void setUri();

    /**
     * @return l'uri delle api da interrogare
     */
    protected String getUriWithQuery(String queryParam, String queryValue) {
        return uri + "?" + queryParam + "=" + queryValue;
    }
}
