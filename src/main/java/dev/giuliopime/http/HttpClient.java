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

import java.util.concurrent.ExecutionException;

public abstract class HttpClient {
    protected Client client = ClientBuilder.newBuilder().build();
    protected UriBuilder uriBuilder = UriBuilder.newInstance();

    protected ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.INDENT_OUTPUT);

    protected HttpClient() {
        setUriBuilder();
    }

    protected <T> T get(String queryParam, String queryValue, Class<T> type) throws JsonProcessingException {
        uriBuilder.queryParam(queryParam, queryValue);

        WebTarget target = client.target(getUri());
        String responseBody = target
                .request(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke()
                .readEntity(String.class);

        return objectMapper.readValue(responseBody, type);
    }

    protected abstract void setUriBuilder();
    protected String getUri() {
        return uriBuilder.build().toString();
    }
}
