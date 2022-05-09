package dev.giuliopime;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Response {
    private String name;
    private String gender;
    private Double probability;

    private String count;
    public Response(@JsonProperty("name") String name,
                    @JsonProperty("gender") String gender,
                    @JsonProperty("probability") Double probability,
                    @JsonProperty("count") String count
    ) {
        this.name = name;
        if (Objects.equals(gender, "male"))
            this.gender = "maschio";
        else
            this.gender = "femmina";
        this.probability = probability;
    }

    public String toString() {
        return name + " è di solito " + gender + " (probabilità " + probability*100 + "%)";
    }
}
