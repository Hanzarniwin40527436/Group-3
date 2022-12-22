package com.napier.sem;

public class Country {

    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Integer Capital;
    private Integer Population;

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public Country(Integer capital) {
        Capital = capital;
    }

    public Integer getCapital() {
        return Capital;
    }

    public void setCapital(Integer capital) {
        Capital = capital;
    }


    public Country(String code, String name, String continent, String region, Integer capital, Integer population) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Capital = capital;
        Population = population;
    }

    public String getCode() {
        return Code;
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