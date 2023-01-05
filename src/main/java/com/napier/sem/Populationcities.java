package com.napier.sem;

public class Populationcities {
    /**
     * People living in cities total
     */
    private long populationtotal;
    /**
     * People living in cities
     */
    private long populationin;
    /**
     * People not living in cities
     */
    private long populationout;

    /**
     * Cities name
     */
    private String Name;
    /**
     * contient
     */
    private String Continent;
    /**
     * Region
     */
    private String Region;

    /**
     * Getter Setter
     */

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
