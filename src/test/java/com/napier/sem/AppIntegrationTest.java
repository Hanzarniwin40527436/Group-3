package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testgetcity(){
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
    void testprintcountryTest() {
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