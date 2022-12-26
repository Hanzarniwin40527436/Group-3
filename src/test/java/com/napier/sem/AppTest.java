package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

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
        city.setID(23232);
        city.setName("Seoul");
        city.setDistrict("Seoul");
        city.setPopulation(9981619);
        cty.add(city);
        app.displayCity(cty);
    }
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
        couty.setCapital(23);

        cou.add(couty);
        app.displayCountry(cou);
    }
}
