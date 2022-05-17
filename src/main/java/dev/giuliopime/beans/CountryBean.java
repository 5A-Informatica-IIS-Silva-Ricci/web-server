package dev.giuliopime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryBean extends Bean{
    @JsonProperty("country_id")
    private String countryId;
    private Double probability;

    public String getProbabilityString() {
        return probability*100 + "$";
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
