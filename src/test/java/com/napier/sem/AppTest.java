package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;


public class AppTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }
    /** Unit Testing City */
    @Test
    void displaycityEmpty(){
        ArrayList<City> cty = new ArrayList<City>();
        app.displayCity(cty);
    }

    @Test
    void printCitiesNullTest() {
        app.displayCity(null);
    }
    @Test
    void printCitiesTestContainsNull() {
        ArrayList<City> cty = new ArrayList<>();
        cty.add(null);
        app.displayCity(cty);
    }

    @Test
    void printCitiesTest() {
        ArrayList<City> cty = new ArrayList<>();
        City city = new City();
        city.setName("Seoul");
        city.setDistrict("Seoul");
        city.setPopulation(9981619);
        cty.add(city);
        app.displayCity(cty);
    }
    //------------------------------------------------------------------------------------------------------------------
    /** Unit Testing Country */
    @Test
    void displaycountryEmpty(){
        ArrayList<Country> cou = new ArrayList<Country>();
        app.displayCountry(cou);
    }

    @Test
    void printcountryNullTest() {
        app.displayCountry(null);
    }
    @Test
    void printcountryTestContainsNull() {
        ArrayList<Country> cou = new ArrayList<Country>();
        cou.add(null);
        app.displayCountry(cou);
    }

    @Test
    void printcountryTest() {
        ArrayList<Country> cou = new ArrayList<Country>();
        Country couty=new Country();
        couty.setCode("ABW");
        couty.setName("Aru-ba");
        couty.setContinent("North America");
        couty.setRegion("Caribbean");
        couty.setPopulation(2342223L);
        couty.setCapital("jakata");

        cou.add(couty);
        app.displayCountry(cou);
    }
    //------------------------------------------------------------------------------------------------------------------
    /** Unit Testing Capital cities */
    @Test
    void displaycapitalcityEmpty(){
        ArrayList<City> capty = new ArrayList<City>();
        app.displaycapitalcity(capty);
    }

    @Test
    void printcapitalcityNullTest() {
        app.displaycapitalcity(null);
    }
    @Test
    void printcapitalcityTestContainsNull() {
        ArrayList<City> capty = new ArrayList<City>();
        capty.add(null);
        app.displaycapitalcity(capty);
    }

    @Test
    void printcapitalcityTest() {
        ArrayList<City> capty = new ArrayList<City>();
       City capt=new City();
        capt.setName("Jarcata");
        capt.setPopulation(1231233);
        capt.setCountryCode("Dubai");
        capty.add(capt);
        app.displaycapitalcity(capty);
    }


}
