package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.AgeBean;
import dev.giuliopime.beans.GenderBean;
import dev.giuliopime.http.HttpClient;

/**
 * Classe per la gestione delle richieste ad <a href="https://genderize.io">api.genderize.io</a>
 */
public class GenderClient extends HttpClient {
    public GenderClient() {
        super();
    }

    /**
     * Richiede all'api il genere più probabile di una persona in base al suo nome
     * @param nome il nome della persona
     * @return {@link AgeBean} classe contenente le informazioni sul genere di una persona
     * @throws JsonProcessingException In caso si ottenga una risposta http non 200 dalle api
     */
    public GenderBean get(String nome) throws JsonProcessingException {
        return super.get("name", nome, GenderBean.class);
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder.host("https://api.genderize.io");
    }
}
