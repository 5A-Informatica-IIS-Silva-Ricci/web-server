package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.NationBean;
import dev.giuliopime.http.HttpClient;

public class NationClient extends HttpClient {
    public NationClient() {
        super();
    }

    public NationBean get(String nome) throws JsonProcessingException {
        return super.get("name", nome, NationBean.class);
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder.host("https://api.nationalize.io");
    }
}
