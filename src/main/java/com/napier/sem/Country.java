package com.napier.sem;

public class Country {
    /**
     * Country's Code
     */
    private String Code;
    /**
     * Country's name
     */
    private String Name;
    /**
     * Country's Continent
     */
    private String Continent;
    /**
     * Country's Region
     */
    private String Region;
    /**
     * Country's Capital
     */
    private String Capital;
    /**
     * Country's Local Name
     */
    private String LocalName;
    /**
     * Country's Population
     */
    private Long Population;
    /**
     * Getter and Setter
     */
    public Long getPopulation() {
        return Population;
    }
    public void setPopulation(Long population) {
        Population = population;
    }
    public String getCode() {
        return Code;
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
    public String getLocalName() {
        return LocalName;
    }
    public void setLocalName(String localName) {
        LocalName = localName;
    }
}