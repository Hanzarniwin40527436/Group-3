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

    /** Integration Testing Country in the world*/
    @Test
    void countryWorldTest() {
        ArrayList<Country> cou=app.getCountryWorld();
        Country cty= cou.get(0);
        assertEquals(cty.getCode(),"CHN");
        assertEquals(cty.getName(),"China");
        assertEquals(cty.getContinent(),"Asia");
        assertEquals(cty.getRegion(),"Eastern Asia");
        assertEquals(cty.getCapital(),"Peking");
    }
    /** Integration Testing Country in the world*/
    @Test
    void countryContinentTest() {
        ArrayList<Country> cou=app.getCountryContinent();
        Country cty= cou.get(0);
        assertEquals(cty.getCode(),"USA");
        assertEquals(cty.getName(),"United States");
        assertEquals(cty.getContinent(),"North America");
        assertEquals(cty.getRegion(),"North America");
        assertEquals(cty.getCapital(),"Washington");
    }
    /** Integration Testing Country in the region*/
    @Test
    void countryRegionTest() {
        ArrayList<Country> cou=app.getCountryRegion();
        Country cty= cou.get(0);
        assertEquals(cty.getCode(),"ITA");
        assertEquals(cty.getName(),"Italy");
        assertEquals(cty.getContinent(),"Europe");
        assertEquals(cty.getRegion(),"Southern Europe");
        assertEquals(cty.getCapital(),"Roma");
    }

    /** Integration Testing City in the world*/
    @Test
    void cityWorldTest() {
        ArrayList<City> cty = app.getCityWorld();
        City city = cty.get(0);
        assertEquals(city.getName(),"Mumbai (Bombay)");
        assertEquals(city.getCountryCode(),"India");
        assertEquals(city.getDistrict(),"Maharashtra");
        assertEquals(city.getPopulation(),10500000);
    }
    /** Integration Testing City in the Continent*/
    @Test
    void cityContinentTest() {
        ArrayList<City> cty = app.getCityContinent();
        City city = cty.get(0);
        assertEquals(city.getName(),"Mumbai (Bombay)");
        assertEquals(city.getCountryCode(),"India");
        assertEquals(city.getDistrict(),"Maharashtra");
        assertEquals(city.getPopulation(),10500000);
    }
    /** Integration Testing City in the Region*/
    @Test
    void cityRegionTest() {
        ArrayList<City> cty = app.getCityRegion();
        City city = cty.get(0);
        assertEquals(city.getName(),"Istanbul");
        assertEquals(city.getCountryCode(),"Turkey");
        assertEquals(city.getDistrict(),"Istanbul");
        assertEquals(city.getPopulation(),8787958);
    }
    /** Integration Testing City in the Region*/
    @Test
    void cityCountryTest() {
        ArrayList<City> cty = app.getCityCountry();
        City city = cty.get(0);
        assertEquals(city.getName(),"New York");
        assertEquals(city.getCountryCode(),"United States");
        assertEquals(city.getDistrict(),"New York");
        assertEquals(city.getPopulation(),8008278);
    }
    /** Integration Testing City in the Region*/
    @Test
    void cityDistrictTest() {
        ArrayList<City> cty = app.getCityDistrict();
        City city = cty.get(0);
        assertEquals(city.getName(),"La Matanza");
        assertEquals(city.getCountryCode(),"Argentina");
        assertEquals(city.getDistrict(),"Buenos Aires");
        assertEquals(city.getPopulation(),1266461);
    }


    /** Integration Testing Capital Cities in the world */
    @Test
    void Testworldcapitalcities() {
        ArrayList<City> capty = app.getcapitalcitiesintheworld();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"Jakarta");
        assertEquals(capt.getPopulation(),9604900 );
        assertEquals(capt.getCountryCode(),"Indonesia");
    }
    /** Integration Testing Capital Cities in the conti */
    @Test
    void Testcontinentcapitalcities(){
        ArrayList<City> capty = app.getcapitalcitiesinthecontinent();
        City capt=capty.get(2);
        assertEquals(capt.getName(),"Berlin");
        assertEquals(capt.getPopulation(),3386667 );
        assertEquals(capt.getCountryCode(),"Germany");
    }
    @Test
    void Testregioncapitalcities(){
        ArrayList<City> capty = app.getcapitalcitiesintheregion();
        City capt=capty.get(0);
        assertEquals(capt.getName(),"Madrid");
        assertEquals(capt.getPopulation(),2879052 );
        assertEquals(capt.getCountryCode(),"Spain");
    }
    @Test
    void Testtopnworldcapitalcities() {
        ArrayList<City> capty = app.getTOPNcapitalcitiesintheworld();
        City capt=capty.get(4);
        assertEquals(capt.getName(),"Tokyo");
        assertEquals(capt.getPopulation(),7980230 );
        assertEquals(capt.getCountryCode(),"Japan");
    }
    @Test
    void Testtopncontinentcapitalcities(){
        ArrayList<City> capty = app.getTOPNcapitalcitiesinthecontinent();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"London");
        assertEquals(capt.getPopulation(),7285000 );
        assertEquals(capt.getCountryCode(),"United Kingdom");
    }

    @Test
    void Testtopnregioncapitalcities(){
        ArrayList<City> capty = app.getTOPNcapitalcitiesintheregion();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"Roma");
        assertEquals(capt.getPopulation(),2643581 );
        assertEquals(capt.getCountryCode(),"Italy");
    }

}