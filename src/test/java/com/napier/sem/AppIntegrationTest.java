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
    void testprintcountryTest() {
        ArrayList<Country> cou = new ArrayList<Country>();
        Country couty=new Country();
        couty.setCode("ABW");
        couty.setName("Aru-ba");
        couty.setContinent("North America");
        couty.setRegion("Caribbean");
        cou.add(couty);
        cou=app.getCountryWorld();
        assertEquals(couty.getCode(),"ABW");
        assertEquals(couty.getName(),"Aru-ba");
        assertEquals(couty.getContinent(),"North America");
        assertEquals(couty.getRegion(),"Caribbean");
    }
    @Test
    void testgetcity() {
        ArrayList<City> cty = new ArrayList<>();
        City city = new City();
        city.setID(23232);
        city.setName("Seoul");
        city.setDistrict("Seoul");
        city.setPopulation(9981619);
        cty.add(city);
        cty=app.getCityWorld();
        assertEquals(city.getID(),23232);
        assertEquals(city.getName(),"Seoul");
        assertEquals(city.getPopulation(),9981619);
    }
    @Test
    void testprintcapitalcitiesTest() {
        ArrayList<City> capty = new ArrayList<City>();
        City capt=new City();
        capt.setName("Jarcata");
        capt.setPopulation(1231233);
        capt.setCountryCode("Dubai");
        capty.add(capt);
       capty=app.getcapitalcitiesintheworld();
        assertEquals(capt.getName(),"Jarcata");
        assertEquals(capt.getPopulation(),1231233);
        assertEquals(capt.getCountryCode(),"Dubai");
    }
}