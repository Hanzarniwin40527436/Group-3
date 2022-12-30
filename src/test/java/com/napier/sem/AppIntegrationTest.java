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
    void Worldcapitalcitiestest() {
        ArrayList<City> capty = app.getcapitalcitiesintheworld();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"Jakarta");
        assertEquals(capt.getPopulation(),9604900 );
        assertEquals(capt.getCountryCode(),"Indonesia");
    }
    /** Integration Testing Capital Cities in the conti */
    @Test
    void Continentcapitalcitiestest(){
        ArrayList<City> capty = app.getcapitalcitiesinthecontinent();
        City capt=capty.get(2);
        assertEquals(capt.getName(),"Berlin");
        assertEquals(capt.getPopulation(),3386667 );
        assertEquals(capt.getCountryCode(),"Germany");
    }
    @Test
    void Regioncapitalcitiestest(){
        ArrayList<City> capty = app.getcapitalcitiesintheregion();
        City capt=capty.get(0);
        assertEquals(capt.getName(),"Madrid");
        assertEquals(capt.getPopulation(),2879052 );
        assertEquals(capt.getCountryCode(),"Spain");
    }
    @Test
    void Topnworldcapitalcitiestest() {
        ArrayList<City> capty = app.getTOPNcapitalcitiesintheworld();
        City capt=capty.get(4);
        assertEquals(capt.getName(),"Tokyo");
        assertEquals(capt.getPopulation(),7980230 );
        assertEquals(capt.getCountryCode(),"Japan");
    }
    @Test
    void Topncontinentcapitalcitiestest(){
        ArrayList<City> capty = app.getTOPNcapitalcitiesinthecontinent();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"London");
        assertEquals(capt.getPopulation(),7285000 );
        assertEquals(capt.getCountryCode(),"United Kingdom");
    }

    @Test
    void Topnregioncapitalcitiestest(){
        ArrayList<City> capty = app.getTOPNcapitalcitiesintheregion();
        City capt=capty.get(1);
        assertEquals(capt.getName(),"Roma");
        assertEquals(capt.getPopulation(),2643581 );
        assertEquals(capt.getCountryCode(),"Italy");
    }
    @Test
    void Peoplelivingincitesincontienttest(){
        ArrayList<Populationcities> pop = app.peopleliveincitiesincontinent();
        Populationcities popul=pop.get(0);
        assertEquals(popul.getContinent(),"Asia");
        assertEquals(popul.getPopulationtotal(), 3705025700L );
        assertEquals(popul.getPopulationin(),18);
        assertEquals(popul.getPopulationout(),82);
    }
    @Test
    void Peoplelivingincitesinregiontest(){
        ArrayList<Populationcities> pop = app.peopleliveincitiesinregion();
        Populationcities popul=pop.get(0);
        assertEquals(popul.getRegion(),"North America");
        assertEquals(popul.getPopulationtotal(), 309632000L );
        assertEquals(popul.getPopulationin(),29);
        assertEquals(popul.getPopulationout(),71);
    }
    @Test
    void Peoplelivingincitesincountrytest(){
        ArrayList<Populationcities> pop = app.peopleliveincitiesincountry();
        Populationcities popul=pop.get(0);
        assertEquals(popul.getName(),"China");
        assertEquals(popul.getPopulationtotal(), 1277558000L );
        assertEquals(popul.getPopulationin(),13);
        assertEquals(popul.getPopulationout(),87);
    }
    /** Top N Populated Country In The World / Continent/ Region */
    @Test
    void TestTopNPopulatedCountriesInTheWorld(){
        ArrayList<Country> cou = app.getTopNPopulatedCountriesInTheWorld();
        Country cty= cou.get(0);
        assertEquals(cty.getCode(),"CHN");
        assertEquals(cty.getName(), "China");
        assertEquals(cty.getContinent(),"Asia");
        assertEquals(cty.getRegion(),"Eastern Asia");
        assertEquals(cty.getCapital(),"Peking");
    }
    @Test
    void TestTopNPopulatedCountriesInTheContinent(){
        ArrayList<Country> cou = app.getTopNPopulatedCountriesInTheContinent();
        Country cty= cou.get(1);
        assertEquals(cty.getCode(),"IND");
        assertEquals(cty.getName(), "India");
        assertEquals(cty.getContinent(),"Asia");
        assertEquals(cty.getRegion(),"Southern and Central Asia");
        assertEquals(cty.getCapital(),"New Delhi");
    }
    @Test
    void TestTopNPopulatedCountriesInTheRegion(){
        ArrayList<Country> cou = app.getTopNPopulatedCountriesInTheRegion();
        Country cty= cou.get(2);
        assertEquals(cty.getCode(),"PHL");
        assertEquals(cty.getName(), "Philippines");
        assertEquals(cty.getContinent(),"Asia");
        assertEquals(cty.getRegion(),"Southeast Asia");
        assertEquals(cty.getCapital(),"Manila");

    }


    /** Top N Populated City In The World / Continent/ Region/ Country/ district  */
    @Test
    void TestTopNPopulatedCityInTheWorld() {
        ArrayList<City> cty = app.getTopNPopulatedCityInTheWorld();
        City city = cty.get(0);
        assertEquals(city.getName(),"Mumbai (Bombay)");
        assertEquals(city.getCountryCode(),"India");
        assertEquals(city.getDistrict(),"Maharashtra");
        assertEquals(city.getPopulation(),10500000);
    }
    @Test
    void TestTopNPopulatedCityInTheContinent() {
        ArrayList<City> cty = app.getTopNPopulatedCityInTheContinent();
        City city = cty.get(1);
        assertEquals(city.getName(),"Seoul");
        assertEquals(city.getCountryCode(),"South Korea");
        assertEquals(city.getDistrict(),"Seoul");
        assertEquals(city.getPopulation(),9981619);
    }
    @Test
    void TestTopNPopulatedCityInTheRegion() {
        ArrayList<City> cty = app.getTopNPopulatedCityInTheRegion();
        City city = cty.get(2);
        assertEquals(city.getName(),"Delhi");
        assertEquals(city.getCountryCode(),"India");
        assertEquals(city.getDistrict(),"Delhi");
        assertEquals(city.getPopulation(),7206704);
    }
    @Test
    void TestTopNPopulatedCityInTheCountry() {
        ArrayList<City> cty = app.getTopNPopulatedCityInTheCountry();
        City city = cty.get(3);
        assertEquals(city.getName(),"Tianjin");
        assertEquals(city.getCountryCode(),"China");
        assertEquals(city.getDistrict(),"Tianjin");
        assertEquals(city.getPopulation(),5286800);
    }
    @Test
    void TestTopNPopulatedCityInTheDistrict() {
        ArrayList<City> cty = app.getTopNPopulatedCityInTheDistrict();
        City city = cty.get(3);
        assertEquals(city.getName(),"Ede");
        assertEquals(city.getCountryCode(),"Netherlands");
        assertEquals(city.getDistrict(),"Gelderland");
        assertEquals(city.getPopulation(),101574);
    }

    @Test
    void TestWorldPopulation() {
        ArrayList<Country> wcou = app.WorldPopulation();
        Country cou = wcou.get(0);
        assertEquals((long)cou.getPopulation() ,6078749450L );

    }

    @Test
    void TestContinentPopulation() {
        ArrayList<Country> ccou = app.ContinentPoupulation();
        Country cou = ccou.get(0);
        assertEquals(cou.getContinent(), "North America");
        assertEquals((long)cou.getPopulation(),482993000L);
    }

    @Test
    void TestRegionPopulation() {
        ArrayList<Country> recou = app.RegionPoupulation();
        Country cou = recou.get(0);
        assertEquals(cou.getRegion(),"Caribbean");
        assertEquals((long)cou.getPopulation(),38140000L);
    }

    @Test
    void TestCountryPopulation() {
        ArrayList<Country> cocou = app.CountryPoupulation();
        Country cou = cocou.get(0);
        assertEquals(cou.getLocalName(),"Aruba");
        assertEquals((long)cou.getPopulation(),103000L);
    }

    @Test
    void TestDistrictPopulation() {
        ArrayList<City> dcou = app.DistrictPoupulation();
        City ct = dcou.get(0);
        assertEquals(ct.getDistrict(),"Kabol");
        assertEquals(ct.getPopulation(),1780000);
    }

    @Test
    void TestCityPopulation() {
        ArrayList<City> cicou = app.CityPoupulation();
        City ct = cicou.get(0);
        assertEquals(ct.getName(),"Kabul");
        assertEquals(ct.getPopulation(), 1780000);
    }

    @Test
    void TestLanguageSpoken() {
        ArrayList<CountryLanguage> lcou = app.LanguageSpoken();
        CountryLanguage ct = lcou.get(0);
        assertEquals(ct.getLanguage(),"Chinese");
        assertEquals((long)ct.getPopulation(),1968265500L);
        assertEquals((long)ct.getPercentage(),12L);
    }


}