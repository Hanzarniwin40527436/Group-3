package com.napier.sem;

public class Populationcities {
    private long populationtotal;
    private int populationin;
    private int populationout;
    private String Name;
    private String Continent;
    private String Region;

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

    public long getPopulationtotal() {
        return populationtotal;
    }

    public void setPopulationtotal(long populationtotal) {
        this.populationtotal = populationtotal;
    }

    public int getPopulationin() {
        return populationin;
    }

    public void setPopulationin(int populationin) {
        this.populationin = populationin;
    }

    public int getPopulationout() {
        return populationout;
    }

    public void setPopulationout(int populationout) {
        this.populationout = populationout;
    }
}
