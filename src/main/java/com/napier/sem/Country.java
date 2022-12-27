package com.napier.sem;

public class Country {

    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private String Capital;
    private Long Population;

    public Long getPopulation() {
        return Population;
    }

    public void setPopulation(Long population) {
        Population = population;
    }





    public String getCode() {
        return Code;
    }

    public Country(String code, String name, String continent, String region, String capital, Long population) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Capital = capital;
        Population = population;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public Country() {
    }
}