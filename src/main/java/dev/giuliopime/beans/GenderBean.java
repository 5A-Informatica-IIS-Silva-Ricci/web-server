package dev.giuliopime.beans;

public class GenderBean {
    private String name;
    private String gender;
    private Double probability;
    private Integer count;

    public String getGenderString() {
        if(getGenderBoolean())
            return "Maschio";
        else
            return "Femmina";
    }

    public Boolean getGenderBoolean() {
        return gender.equalsIgnoreCase("male");
    }

    public Boolean isFemale() {
        return gender.equalsIgnoreCase("female");
    }

    public Boolean isMale() {
        return gender.equalsIgnoreCase("male");
    }

    public String getProbabilityString() {
        return probability*100 + "$";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
