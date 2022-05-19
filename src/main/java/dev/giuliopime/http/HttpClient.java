package dev.giuliopime.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;

/**
 * Classe generica per la gestione di un client http
 */
public abstract class HttpClient {
    /**
     * Il client che eseguirà le richieste http, utilizza Jersey
     */
    protected Client client = ClientBuilder.newClient();
    /**
     * Un builder per l'uri delle api
     */
    protected UriBuilder uriBuilder = UriBuilder.newInstance();

    /**
     * Consente di convertire una stringa in una classe java deserializzandola
     */
    protected ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.INDENT_OUTPUT);

    protected HttpClient() {
        setUriBuilder();
    }

    /**
     * Metodo generico per effettuare una richiesta http indipendentemente dal tipo di risposta.
     * Andrà specificato il tipo di risposta che si ottiene dalla richiesta attraverso la classe java corrispondente.
     * Utilizza come uri quello ottenuto da {@link #getUri()}.
     * @param queryParam il nome del parametro della query (esempio: name)
     * @param queryValue il valore del parametro della query (esempio: giulio)
     * @param type La classe java che rappresenta la risposta che si vuole ottenere (esempio: Bean.class)
     * @return La classe indicata nel parametro type
     * @throws JsonProcessingException In caso la risposta delle api non coincida con la classe specificata
     */
    protected <T> T get(String queryParam, String queryValue, Class<T> type) throws JsonProcessingException {
        uriBuilder.queryParam(queryParam, queryValue);

        WebTarget target = client.target(getUri());
        String responseBody = target
                .request(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke()
                // Prendo il contenuto del `data` della risposta
                .readEntity(String.class);

        // Converto la stringa in class con l'objectMapper
        return objectMapper.readValue(responseBody, type);
    }

    /**
     * Imposta l'uri builder a seconda dell'indirizzo delle api da richiamare
     */
    protected abstract void setUriBuilder();

    /**
     * @return l'uri delle api da interrogare
     */
    protected String getUri() {
        return uriBuilder.build().toString();
    }
}
