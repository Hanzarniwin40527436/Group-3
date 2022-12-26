package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.charset.CoderResult;
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
        ArrayList<Country> cou=app.getCountryWorld();
        Country cty= cou.get(0);
        assertEquals(cty.getCode(),"CHN");
        assertEquals(cty.getName(),"China");
        assertEquals(cty.getContinent(),"Asia");
        assertEquals(cty.getRegion(),"Eastern Asia");
    }
    @Test
    void testgetcity() {
        ArrayList<City> cty = app.getCityWorld();
        City city = cty.get(0);
        assertEquals(city.getID(),1024);
        assertEquals(city.getName(),"Mumbai (Bombay)");
        assertEquals(city.getDistrict(),"Maharashtra");
        assertEquals(city.getPopulation(),10500000);
    }
    @Test
    void testprintcapitalcitiesTest() {
        ArrayList<City> capty = app.getcapitalcitiesintheworld();
        City capt=capty.get(0);
        assertEquals(capt.getName(),"Seoul");
        assertEquals(capt.getPopulation(),9981619 );
        assertEquals(capt.getCountryCode(),"South Korea");
    }
}