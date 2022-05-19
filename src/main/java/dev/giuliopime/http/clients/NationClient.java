package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.AgeBean;
import dev.giuliopime.beans.NationBean;
import dev.giuliopime.http.HttpClient;

import java.io.IOException;

/**
 * Classe per la gestione delle richieste ad <a href="https://nationalize.io">api.nationalize.io</a>
 */
public class NationClient extends HttpClient {
    public NationClient() {
        super();
    }

    /**
     * Richiede all'api la nazione più probabile di una persona in base al suo nome
     * @param nome il nome della persona
     * @return {@link AgeBean} classe contenente le informazioni sulla nazione di una persona
     * @throws UnknownError In caso si ottenga una risposta http non 200 dalle api
     */
    public NationBean get(String nome) throws UnknownError {
        return super.get("name", nome, NationBean.class);
    }

    @Override
    protected void setUri() {
        uri = "https://api.nationalize.io";
    }


}
