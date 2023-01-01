package com.napier.sem;

public class Populationcities {
    private long populationtotal;
    private long populationin;
    private long populationout;
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

    public long getPopulationin() {
        return populationin;
    }

    public void setPopulationin(long populationin) {
        this.populationin = populationin;
    }

    public long getPopulationout() {
        return populationout;
    }

    public void setPopulationout(long getPopulationout) {
        this.populationout = getPopulationout;
    }

}
