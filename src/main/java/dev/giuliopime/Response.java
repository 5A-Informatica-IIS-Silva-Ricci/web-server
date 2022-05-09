package dev.giuliopime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    private String activity;
    private String type;
    private String participants;
    private String price;
    private String link;
    private String key;
    private String accessibility;

    public Response(@JsonProperty("activity") String activity,
                    @JsonProperty("type") String type,
                    @JsonProperty("participants") String participants,
                    @JsonProperty("price") String price,
                    @JsonProperty("link") String link,
                    @JsonProperty("key") String key,
                    @JsonProperty("accessibility") String accessibility
    ) {
        this.activity = activity;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
        this.key = key;
        this.accessibility = accessibility;
    }

    public String toString() {
        return "activity: " + activity + ", type: " + type;
    }
}
