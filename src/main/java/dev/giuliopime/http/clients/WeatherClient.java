package dev.giuliopime.http.clients;

import dev.giuliopime.Environment;
import dev.giuliopime.http.HttpClient;
import jakarta.ws.rs.core.UriBuilder;

public class WeatherClient extends HttpClient {

    public WeatherClient() throws NoSuchFieldException {
        this.uri.host("").queryParam("api_key", Environment.getInstance().getValore(""));


    }

    @Override
    protected void setUri() {
        this.uriBuilder
                .host("")
                .queryParam("api_key", Environment.GEOLOCATION_API_KEY);

        this.uri = this.uriBuilder
                .build()
                .toString();
    }
}
