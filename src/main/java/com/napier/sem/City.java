package com.napier.sem;
public class City
{
    /**
     * City ID
     */
    private int ID;
    /**
     * City's name
     */
    private String Name;
    /**
     * City's District
     */
    private String District;
    /**
     * City's Population
     */
    private int Population;

    /**
     * Getter Setter
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Country Code
     */
    private String CountryCode;
    public City(int ID, String name, String district, int population, String countryCode) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        CountryCode = countryCode;
    }

    public City(){

    }
}