package dev.giuliopime;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class WsClient {
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

        System.out.println(response.readEntity(dev.giuliopime.Response.class).toString());
    }
}
