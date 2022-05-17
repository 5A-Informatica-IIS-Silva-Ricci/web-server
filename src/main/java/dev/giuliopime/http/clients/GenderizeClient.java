package dev.giuliopime.http.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.beans.GenderBean;
import dev.giuliopime.http.HttpClient;

public class GenderizeClient extends HttpClient {
    public GenderizeClient() {
        super();
    }

    protected GenderBean get(String nome) throws JsonProcessingException {
        return super.get("name", nome, GenderBean.class);
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder.host("https://api.genderize.io");
    }
}
