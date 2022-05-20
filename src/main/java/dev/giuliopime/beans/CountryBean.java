package dev.giuliopime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Locale;

public class CountryBean {
    @JsonProperty("country_id")
    private String countryId;
    private Double probability;

    public String getProbabilityString() {
        return probability*100 + "$";
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountry() {
        Locale loc = new Locale("it_IT", countryId);
        return loc.getDisplayCountry(Locale.ITALIAN);
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
