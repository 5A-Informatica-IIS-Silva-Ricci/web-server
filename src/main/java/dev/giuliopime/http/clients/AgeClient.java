package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.AgeBean;
import dev.giuliopime.http.HttpClient;

/**
 * Classe per la gestione delle richieste ad <a href="https://agify.io">api.agify.io</a>
 */
public class AgeClient extends HttpClient {
    public AgeClient() {
        super();
    }

    /**
     * Richiede all'api l'età più probabile di una persona in base al suo nome
     * @param nome il nome della persona
     * @return {@link AgeBean} classe contenente le informazioni sull'età di una persona
     * @throws JsonProcessingException In caso si ottenga una risposta http non 200 dalle api
     */
    public AgeBean get(String nome) throws JsonProcessingException {
        return super.get("name", nome, AgeBean.class);
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder.host("https://api.agify.io");
    }
}
