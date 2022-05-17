package dev.giuliopime.http.clients;

import dev.giuliopime.Environment;
import dev.giuliopime.http.HttpClient;
import jakarta.ws.rs.core.UriBuilder;

public class IpLocatorClient extends HttpClient {
    public IpLocatorClient() {
        super();
    }

    @Override
    protected void setUriBuilder() {
        uriBuilder = uriBuilder
                .host("https://ipgeolocation.abstractapi.com")
                .path("v1")
                .queryParam("api_key", Environment.GEOLOCATION_API_KEY);
    }

    @Override
    protected void setUri() {
        uri = uriBuilder.build().toString();
    }
}
