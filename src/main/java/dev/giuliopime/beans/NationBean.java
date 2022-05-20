package dev.giuliopime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
public class NationBean {
    private String name;
    @JsonProperty("country")
    private ArrayList<CountryBean> countries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CountryBean> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryBean> countries) {
        this.countries = countries;
    }
}
