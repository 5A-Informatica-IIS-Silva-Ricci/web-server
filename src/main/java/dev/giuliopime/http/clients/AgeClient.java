package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.AgeBean;
import dev.giuliopime.http.HttpClient;

public class AgeClient extends HttpClient {
    public AgeClient() {
        super();
    }

    public AgeBean get(String nome) throws JsonProcessingException {
        return super.get("name", nome, AgeBean.class);
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder.host("https://api.agify.io");
    }
}
