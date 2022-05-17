package dev.giuliopime.http;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

public abstract class HttpClient {
    protected UriBuilder uriBuilder = UriBuilder.newInstance();
    protected String uri;
    protected Client client = ClientBuilder.newBuilder().build();

    protected HttpClient() {
        setUriBuilder();
        setUri();
    }


    public void start() {
        String baseUrl = "https://api.genderize.io?name=";
        String name = "Nadir";
        String uri = baseUrl + name;

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(uri);
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke();
    }

    protected abstract void setUriBuilder();
    protected abstract void setUri();
}
