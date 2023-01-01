package com.napier.sem;

import java.awt.event.MouseWheelEvent;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;


public class App {
    public static void main(String[] args) {
        /** Create new Application */
        App app = new App();

        /** Connect to database */
        if (args.length < 1) {
            app.connect("localhost:33060", 30000);
        } else {
            app.connect(args[0], Integer.parseInt(args[1]));
        }
        /** All the countries in the world/continent/region organised by largest population to smallest. */
        ArrayList<Country> cou = app.getCountryWorld();
        ArrayList<Country> cou1 = app.getCountryContinent();
        ArrayList<Country> cou2 = app.getCountryRegion();
        /** the top N populated countries in the world/continent/region by the user. */
        ArrayList<Country> coun = app.getTopNPopulatedCountriesInTheWorld();
        ArrayList<Country> coun1 = app.getTopNPopulatedCountriesInTheContinent();
        ArrayList<Country> coun2 = app.getTopNPopulatedCountriesInTheRegion();
        /** All the cities in the world/continent/region/country/district organised by largest population to smallest. */
        ArrayList<City> cty = app.getCityWorld();
        ArrayList<City> cty1 = app.getCityContinent();
        ArrayList<City> cty2 = app.getCityRegion();
        ArrayList<City> cty3 = app.getCityCountry();
        ArrayList<City> cty4 = app.getCityDistrict();
        /** The top N populated cities provided by the user*/
        ArrayList<City> ctyn = app.getTopNPopulatedCityInTheWorld();
        ArrayList<City> ctyn1 =  app.getTopNPopulatedCityInTheContinent();
        ArrayList<City> ctyn2 = app.getTopNPopulatedCityInTheRegion();
        ArrayList<City> ctyn3 = app.getTopNPopulatedCityInTheCountry();
        ArrayList<City> ctyn4 = app.getTopNPopulatedCityInTheDistrict();
        /** All the capital cities in the world/continent/region organized by largest population to smallest */
        ArrayList<City> capty = app.getcapitalcitiesintheworld();
        ArrayList<City> capty1 = app.getcapitalcitiesinthecontinent();
        ArrayList<City> capty2 = app.getcapitalcitiesintheregion();
        /** the top N populated capital cities in the world/continent/region where N is provided by the user. */
        ArrayList<City> captyn = app.getTOPNcapitalcitiesintheworld();
        ArrayList<City> captyn1 = app.getTOPNcapitalcitiesinthecontinent();
        ArrayList<City> captyn2 = app.getTOPNcapitalcitiesintheregion();
        /** Population from World/Continent/Region  */
        ArrayList<Country> wcou = app.WorldPopulation();
        ArrayList<Country> ccou = app.ContinentPoupulation();
        ArrayList<Country> recou = app.RegionPoupulation();
        ArrayList<Country> cocou = app.CountryPoupulation();
        ArrayList<City> dcou = app.DistrictPoupulation();
        ArrayList<City> cicou = app.CityPoupulation();
        ArrayList<CountryLanguage> lcou = app.LanguageSpoken();
        /** the report of the population of people, people living in cities, and people not living in cities in each country. */

        ArrayList<Populationcities> pop = app.peopleliveincitiesincontinent();
        ArrayList<Populationcities> pop1 = app.peopleliveincitiesinregion();
        ArrayList<Populationcities> pop2 = app.peopleliveincitiesincountry();
        /** display country*/
        System.out.println("1# Display country in the world");
        app.displayCountry(cou);
        System.out.println("2# Display country in the continent");
        app.displayCountry(cou1);
        System.out.println("3# Display country in the region");
        app.displayCountry(cou2);
        System.out.println("4# Top N populated countries in the world");
        app.displayCountry(coun);
        System.out.println("5# Top N populated countries in the continent");
        app.displayCountry(coun1);
        System.out.println("6# Top N populated countries in the region");
        app.displayCountry(coun2);
        /** display city*/
        System.out.println("7# Display city in the world");
        app.displayCity(cty);
        System.out.println("8# Display city in a continent");
        app.displayCity(cty1);
        System.out.println("9# Display city in a region");
        app.displayCity(cty2);
        System.out.println("10# Display city in a country");
        app.displayCity(cty3);
        System.out.println("11# Display city in a district");
        app.displayCity(cty4);
        System.out.println("12# Top N populated cities in the world");
        app.displayCity(ctyn);
        System.out.println("13 Top N populated cities in the Continent");
        app.displayCity(ctyn1);
        System.out.println("14# Top N populated cities in the region");
        app.displayCity(ctyn2);
        System.out.println("15# Top N populated countries in the country");
        app.displayCity(ctyn3);
        System.out.println("16# Top N populated countries in the district");
        app.displayCity(ctyn4);
        /** display capital city */
        System.out.println("17# Display capital city in a world");
        app.displaycapitalcity(capty);
        System.out.println("18# Display capital city in the Continent");
        app.displaycapitalcity(capty1);
        System.out.println("19# Display capital city in the Region");
        app.displaycapitalcity(capty2);
        System.out.println("20# Top N populated capital cities in the world");
        app.displaycapitalcity(captyn);
        System.out.println("21# Top N populated capital cities in the Continent");
        app.displaycapitalcity(captyn1);
        System.out.println("22# Top N populated capital cities in the Region");
        app.displaycapitalcity(captyn2);
        /** display population */
        System.out.println("23# World Population");
        app.displayPopulation(wcou);
        System.out.println("24# Continent Population");
        app.displayContinentPopulation(ccou);
        System.out.println("25# Region Population");
        app.displayRegionPopulation(recou);
        System.out.println("26# Country Population");
        app.displayCountryPopulation(cocou);
        System.out.println("27# District Population");
        app.displayDistrictPopulation(dcou);
        System.out.println("28# City Population");
        app.displayCityPopulation(cicou);
        System.out.println("29# Language Spoken");
        app.displayLanguageSpoken(lcou);
        /** Display of the population of people */
        System.out.println("30# The report of the population of people, people living in cities, and people not living in cities in each country");
        app.displaypopulationlivingincitiesornotcountry(pop2);
        System.out.println("31# The report of the population of people, people living in cities, and people not living in cities in each continent");
        app.displaypopulationlivingincitiesornotcontinent(pop);
        System.out.println("32# The report of the population of people, people living in cities, and people not living in cities in each region");
        app.displaypopulationlivingincitiesornotregion(pop1);
        /** Disconnect from database */
        app.disconnect();
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     * Connection
     */
    private Connection con = null;

    /**
     *
     * @return All the countries in the world organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population , city.Name "
                            + "FROM country, city "
                            + "WHERE city.ID= country.Capital "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist

            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the countries in the continent organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population , city.Name "
                            + "FROM country, city "
                            + "WHERE city.ID= country.Capital AND Continent = 'North America' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the countries in the region organised by largest population to smallest.
     */
    public ArrayList<Country> getCountryRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE city.ID= country.Capital AND Region = 'Southern Europe' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return The top N populated countries in the world where N is provided by the user.
    */
    public ArrayList<Country> getTopNPopulatedCountriesInTheWorld()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.ID, city.Name "+
                            "FROM country, city "+ "Where country.Capital = city.ID " +
                            "ORDER BY country.Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated countries in the world");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return The top N populated countries in a continent where N is provided by the user.
    */
    public ArrayList<Country> getTopNPopulatedCountriesInTheContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.ID, city.Name "+
                            "FROM country, city "+ "Where country.Capital = city.ID AND country.Continent = 'Asia' " +
                            "ORDER BY country.Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated countries in the continent");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated countries in a region where N is provided by the user..
    */
    public ArrayList<Country> getTopNPopulatedCountriesInTheRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.ID, city.Name "+
                            "FROM country, city "+ "Where country.Capital = city.ID AND Region= 'Southeast Asia' " +
                            "ORDER BY country.Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("country.Code"));
                ct.setName(rset.getString("country.Name"));
                ct.setContinent(rset.getString("country.Continent"));
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("country.Population"));
                ct.setCapital(rset.getString("city.Name"));
                cou.add(ct);
            }
            return cou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated countries in the region");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------

    /**
     *
     * Display Country function
     */
    public void displayCountry(ArrayList<Country> cou) {
        if (cou == null)
        {
            System.out.println("No Country found");
            return;
        }
        if(cou.isEmpty()){
            System.out.println("Array List is Empty");
            return;

        }
        if(cou.contains(null)){
            System.out.println("Array List contain Null");
            return;
        }
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-4s %-1s %-45s %-1s %-15s %-1s %-25s %-1s %-38s %-1s %-12s %-1s","|", "Code", "|","Name", "|","Continent","|", "Region", "|","Capital","|", "Population","|"));
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        //
        for (Country ct : cou) {
            if(ct==null)
                continue;

            String city_string =
                    String.format("%-1s %-4s %-1s %-45s %-1s %-15s %-1s %-25s %-1s %-38s %-1s %-12s %-1s",
                            "|",ct.getCode(), "|",ct.getName(), "|",ct.getContinent(),"|",ct.getRegion(), "|",ct.getCapital(),"|", ct.getPopulation(),"|");
            System.out.println(city_string);

        }
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the cities in the world organised by largest population to smallest.
     */
    public ArrayList<City> getCityWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population  "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the cities in a continent organised by largest population to smallest.
     */
    public ArrayList<City> getCityContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the cities in a region organised by largest population to smallest.
     */
    public ArrayList<City> getCityRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Region = 'Middle East' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the cities in a district organised by largest population to smallest.
     */
    public ArrayList<City> getCityCountry() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population  "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Name = 'United States' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the cities in a district organised by largest population to smallest.
     */
    public ArrayList<City> getCityDistrict() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population  "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = 'Buenos Aires' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated cities in the world where N is provided by the user.
     */
    public ArrayList<City> getTopNPopulatedCityInTheWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, city.District "+
                            "FROM city, country " + "WHERE city.CountryCode = country.Code " +
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated cities in the world");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated cities in the continent where N is provided by the user.
     */
    public ArrayList<City> getTopNPopulatedCityInTheContinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, city.District "+
                            "FROM city, country " + "WHERE city.CountryCode = country.Code AND country.Continent = 'Asia' " +
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated cities in the world");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated cities in the Region where N is provided by the user.
     */
    public ArrayList<City> getTopNPopulatedCityInTheRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, city.District "+
                            "FROM city, country " + "WHERE city.CountryCode = country.Code AND country.Region = 'Southern and Central Asia' " +
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated cities in the world");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated cities in the Country where N is provided by the user.
     */
    public ArrayList<City> getTopNPopulatedCityInTheCountry() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, city.District "+
                            "FROM city, country " + "WHERE city.CountryCode = country.Code AND country.Name = 'China' " +
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated cities in the world");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * The top N populated cities in the Discrict where N is provided by the user.
     */
    public ArrayList<City> getTopNPopulatedCityInTheDistrict() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, city.District "+
                            "FROM city, country " + "WHERE city.CountryCode = country.Code AND city.District = 'Gelderland' " +
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setCountryCode(rset.getString("country.Name"));
                ct.setDistrict(rset.getString("city.District"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated cities in the world");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * Display city function
     */
    public void displayCity(ArrayList<City> cty) {
        if (cty == null) {
            System.out.println("No City");
            return;
        }
        if(cty.isEmpty()){
            System.out.println("Array List is Empty");
            return;

        }
       if(cty.contains(null)){
            System.out.println("Array List contain Null");
            return;
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-31s %-1s %-38s %-1s %-20s %-1s %-10s %-1s", "|", "Name", "|", "Country", "|", "District", "|", "Population", "|"));
        System.out.println("|--------------------------------------------------------------------------------------------------------------|");
        //
        for (City ct : cty) {
            if (ct == null)
                continue;

            String city_string =
                    String.format("%-1s %-31s %-1s %-38s %-1s %-20s %-1s %-10s %-1s",
                            "|", ct.getName(),"|", ct.getCountryCode(),"|", ct.getDistrict(),"|", ct.getPopulation(),"|");
            System.out.println(city_string);
        }
        System.out.println("|--------------------------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the capital cities in the world organised by largest population to smallest.
     */
    public ArrayList<City> getcapitalcitiesintheworld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                    "FROM city, country "+
                    "WHERE city.ID= country.Capital "+
                    "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the capital cities in the continent organised by largest population to smallest.
     */
    public ArrayList<City> getcapitalcitiesinthecontinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                            "FROM city, country "+
                            "WHERE city.ID= country.Capital AND country.Continent='Europe' "+
                            "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return All the capital cities in the region organised by largest population to smallest.
     */
    public ArrayList<City> getcapitalcitiesintheregion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                            "FROM city, country "+
                            "WHERE city.ID= country.Capital AND country.Region='Southern Europe' "+
                            "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the top N populated capital cities in the world where N is provided by the user.
     */
    public ArrayList<City> getTOPNcapitalcitiesintheworld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                            "FROM city, country "+
                            "WHERE city.ID= country.Capital "+
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the top N populated capital cities in the region where N is provided by the user.
     */
    public ArrayList<City> getTOPNcapitalcitiesintheregion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                            "FROM city, country "+
                            "WHERE city.ID= country.Capital AND country.Region='Southern Europe' "+
                            "ORDER BY city.Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the top N populated capital cities in the continent where N is provided by the user.
     */
    public ArrayList<City> getTOPNcapitalcitiesinthecontinent() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.population, city.Name ,country.Name "+
                            "FROM city, country "+
                            "WHERE city.ID= country.Capital AND country.Continent='Europe' "+
                            "ORDER BY city.Population DESC " + "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cty = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("country.Name"));
                cty.add(ct);
            }
            return cty;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * Display capital city
     */
    public void displaycapitalcity(ArrayList<City> cty) {
        if (cty == null)
        {
            System.out.println("No Capital City");
            return;
        }
        if(cty.isEmpty()){
            System.out.println("Array List is Empty");
            return;
        }
        if(cty.contains(null)){
            System.out.println("Array List contain Null");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s","|","Population","|","City","|","Country","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all employees in the list
        for (City ct : cty) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s",
                            "|",ct.getPopulation(),"|",ct.getName(),"|",ct.getCountryCode(),"|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the World.
     */
    public ArrayList<Country> WorldPopulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) "+ "FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> wcou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setPopulation(rset.getLong("SUM(Population)"));
                wcou.add(ct);
            }
            return wcou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get World population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the World Display.
     */
    public void displayPopulation(ArrayList<Country> wcou){
        if (wcou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format( "%-35s","Total Population of the World"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all country in the list
        for (Country ct : wcou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format(" %-35s ",
                            ct.getPopulation());
            System.out.println(emp_string);

        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Continent.
     */
    public ArrayList<Country> ContinentPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Continent ,SUM(Population) "+ "FROM country "+ "GROUP BY Continent ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> ccou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setContinent(rset.getString("Continent"));
                ct.setPopulation(rset.getLong("SUM(Population)"));
                ccou.add(ct);
            }
            return ccou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Continent Population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Continent display.
     */
    public void displayContinentPopulation(ArrayList<Country> ccou){
        if (ccou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-20s %-1s","|","Continent","|","Total Population","|"));
        System.out.println("|-------------------------------------------------------------------|");
        // Loop over all country in the list
        for (Country ct : ccou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-20s %-1s",
                            "|",ct.getContinent(),"|",ct.getPopulation(),"|");
            System.out.println(emp_string);

        }
        System.out.println("|-------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Region.
     */
    public ArrayList<Country> RegionPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Region ,SUM(Population) "+ "FROM country "+ "GROUP BY Region";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> recou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getLong("SUM(Population)"));
                recou.add(ct);
            }
            return recou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Region Population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Region display.
     */
    public void displayRegionPopulation(ArrayList<Country> recou){
        if (recou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-20s %-1s ","|","Region","|","Total Population","|"));
        System.out.println("|-------------------------------------------------------------------|");
        // Loop over all country in the list
        for (Country ct : recou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-20s %-1s ",
                            "|",ct.getRegion(),"|",ct.getPopulation(),"|");
            System.out.println(emp_string);

        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------

    public ArrayList<Country> CountryPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT LocalName ,SUM(Population) "+ "FROM country "+ "GROUP BY LocalName";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<Country> cocou = new ArrayList<Country>();
            //While loop for SQL
            while (rset.next()) {
                Country ct = new Country();
                ct.setLocalName(rset.getString("LocalName"));
                ct.setPopulation(rset.getLong("SUM(Population)"));
                cocou.add(ct);
            }
            return cocou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country Population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Country display.
     */
    public void displayCountryPopulation(ArrayList<Country> cocou){
        if (cocou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-20s %-1s ","|","LocalName","|","Total Population","|"));
        System.out.println("|-------------------------------------------------------------------|");
        // Loop over all country in the list
        for (Country ct : cocou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-20s %-1s ",
                            "|",ct.getLocalName(),"|",ct.getPopulation(),"|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    public ArrayList<City> DistrictPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT District ,SUM(Population) "+ "FROM city "+ "GROUP BY District";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> dcou = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setDistrict(rset.getString("District"));
                ct.setPopulation(rset.getInt("SUM(Population)"));
                dcou.add(ct);
            }
            return dcou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get District Population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Country display.
     */
    public void displayDistrictPopulation(ArrayList<City> dcou){
        if (dcou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-20s %-1s ","|","District","|","Total Population","|"));
        System.out.println("|-------------------------------------------------------------------|");
        // Loop over all City in the list
        for (City ct : dcou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-20s %-1s ",
                            "|",ct.getDistrict(),"|",ct.getPopulation(),"|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    public ArrayList<City> CityPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name ,SUM(Population) "+ "FROM city "+ "GROUP BY Name";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<City> cicou = new ArrayList<City>();
            //While loop for SQL
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("Name"));
                ct.setPopulation(rset.getInt("SUM(Population)"));
                cicou.add(ct);
            }
            return cicou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City Population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return Population of the Country display.
     */
    public void displayCityPopulation(ArrayList<City> cicou){
        if (cicou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-20s %-1s ","|","Name","|","Total Population","|"));
        System.out.println("|-------------------------------------------------------------------|");
        // Loop over all city in the list
        for (City ct : cicou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-20s %-1s ",
                            "|",ct.getName(),"|",ct.getPopulation(),"|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /** public ArrayList<CountryLanguage> LanguageSpoken(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Language ,SUM(Population), AVG(Percentage) "+ "FROM countrylanguage, country "+"WHERE countrylanguage.CountryCode = country.Code AND Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')"+"GROUP BY Language ORDER BY SUM(Population) DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<CountryLanguage> lcou = new ArrayList<CountryLanguage>();
            //While loop for SQL
            while (rset.next()) {
                CountryLanguage ct = new CountryLanguage();
                ct.setLanguage(rset.getString("Language"));
                ct.setPopulation(rset.getLong("SUM(Population)"));
                ct.setPercentage(rset.getLong("AVG(Percentage)"));
                lcou.add(ct);
            }
            return lcou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Spoken Language details");
            return null;
        }
    } */
    public ArrayList<CountryLanguage> LanguageSpoken(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Language ,SUM(Population) ,SUM(Population*Percentage)/6078749450 "+ "FROM countrylanguage, country "+"WHERE countrylanguage.CountryCode = country.Code AND Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')"+"GROUP BY Language ORDER BY SUM(Population) DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // create new arraylist
            ArrayList<CountryLanguage> lcou = new ArrayList<CountryLanguage>();
            //While loop for SQL
            while (rset.next()) {
                CountryLanguage ct = new CountryLanguage();
                ct.setLanguage(rset.getString("Language"));
                ct.setPopulation(rset.getLong("SUM(Population)"));
                ct.setPercentage(rset.getLong("AVG(Percentage)"));
                lcou.add(ct);
            }
            return lcou;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Spoken Language details");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the language spoken
     */
    public void displayLanguageSpoken(ArrayList<CountryLanguage> lcou){
        if (lcou == null)
        {
            System.out.println("No Language");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-35s %-1s %-38s %-1s %-9s  %-1s","|","Language","|","Total Population","|","Percentage","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all languages in the list
        for (CountryLanguage ct : lcou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-35s %-1s %-38s %-1s %-9s%% %-1s ",
                            "|",ct.getLanguage(),"|",ct.getPopulation(),"|",ct.getPercentage(),"|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }


    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the report of the population of people, people living in cities, and people not living in cities in each continent.
     */
    private String continent="Asia";
    public ArrayList<Populationcities> peopleliveincitiesincontinent() {
        try {
            // Create an SQL statement
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            // Create string for SQL statement
            String strSelect1 = "SELECT SUM(Population) " + "FROM country "+ "WHERE continent= " + continent;
            String strSelect2 = "SELECT country.Continent,SUM(city.Population) " + "FROM city, country " + "WHERE city.CountryCode = country.Code AND country.continent= "+continent;
            // Execute SQL statement
            ResultSet rset1 = stmt1.executeQuery(strSelect1);
            ResultSet rset2 = stmt2.executeQuery(strSelect2);
            // create new arraylist
            ArrayList<Populationcities> pop = new ArrayList<>();
            long citytotal=0;
            long cityin=0;
            String conti="";

            while (rset1.next()) {
                citytotal=rset1.getLong("SUM(Population)");

            }
            while (rset2.next()) {
                cityin=rset2.getLong("SUM(city.Population)");
                conti=rset2.getString("Country.Continent");

            }

            long cityout= citytotal-cityin;
            int percentin=(int)(cityin*100/citytotal);
            int percentout=100-percentin;

            Populationcities popul=new Populationcities();
           popul.setContinent(conti);
            popul.setPopulationtotal(citytotal);
            popul.setPopulationin(percentin);
            popul.setPopulationout(percentout);

            pop.add(popul);
            return  pop;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities living in population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    public void displaypopulationlivingincitiesornotcontinent(ArrayList<Populationcities> popul){
        if (popul == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-14s %-19s  %-23s  %-20s %-1s ","|","Continent","Population Total","People living in Cities","People not living in cities ","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all Population in the list
        for (Populationcities populat : popul) {
            if(populat==null)
                continue;

            String emp_string =
                    String.format("%-1s %-14s %-19s  %-3s%% %20s %-3s%% %-22s %-1s",
                             '|',populat.getContinent(), populat.getPopulationtotal(), populat.getPopulationin(),"",populat.getPopulationout(),"",'|');
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the report of the population of people, people living in cities, and people not living in cities in each region.
     */
    public ArrayList<Populationcities> peopleliveincitiesinregion() {
        try {
            // Create an SQL statement
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            // Create string for SQL statement
            String strSelect1 = "SELECT SUM(Population) " + "FROM country "+ "WHERE country.Region='North America'";
            String strSelect2 = "SELECT country.Region, SUM(city.Population) " + "FROM city, country " + "WHERE city.CountryCode = country.Code AND country.Region='North America'";

            // Execute SQL statement
            ResultSet rset1 = stmt1.executeQuery(strSelect1);
            ResultSet rset2 = stmt2.executeQuery(strSelect2);

            ArrayList<Populationcities> pop = new ArrayList<>();
            long citytotal=0;
            long cityin=0;
            String regi="";
            while (rset1.next()) {
                citytotal=rset1.getLong("SUM(Population)");
            }
            while (rset2.next()) {
                cityin=rset2.getLong("SUM(city.Population)");
                regi=rset2.getString("country.Region");
            }
            long cityout= citytotal-cityin;
            int percentin=(int)(cityin*100/citytotal);
            int percentout=100-percentin;

            Populationcities popul=new Populationcities();
            popul.setRegion(regi);
            popul.setPopulationtotal(citytotal);
            popul.setPopulationin(percentin);
            popul.setPopulationout(percentout);

            pop.add(popul);
            return  pop;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities living in population details");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    /**
     *
     * @return the report of the population of people, people living in cities, and people not living in cities in each country.
     */
    public ArrayList<Populationcities> peopleliveincitiesincountry() {
        try {
            // Create an SQL statement
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            // Create string for SQL statement
            String strSelect1 = "SELECT SUM(Population) " + "FROM country "+ "WHERE country.Name='China'";
            String strSelect2 = "SELECT country.Name,sum(city.Population) "+"FROM city,country "+"WHERE city.CountryCode = country.Code AND country.Name='China'";

            // Execute SQL statement
            ResultSet rset1 = stmt1.executeQuery(strSelect1);
            ResultSet rset2 = stmt2.executeQuery(strSelect2);

            ArrayList<Populationcities> pop = new ArrayList<>();
            long citytotal=0;
            long cityin=0;
            String ctname="";
            while (rset1.next()) {
                citytotal=rset1.getLong("SUM(Population)");
            }
            while (rset2.next()) {
                cityin=rset2.getLong("SUM(city.Population)");
                ctname=rset2.getString("country.Name");
            }
            long cityout= citytotal-cityin;
            int percentin=(int)(cityin*100/citytotal);
            int percentout=100-percentin;


            Populationcities popul=new Populationcities();
            popul.setName(ctname);
            popul.setPopulationtotal(citytotal);
            popul.setPopulationin(percentin);
            popul.setPopulationout(percentout);

            pop.add(popul);
            return  pop;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities living in population details");
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    public void displaypopulationlivingincitiesornotcountry(ArrayList<Populationcities> popul){
        if (popul == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-14s %-19s  %-23s  %-20s %-1s ","|","Country","Population Total","People living in Cities","People not living in cities","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all Population in the list
        for (Populationcities populat : popul) {
            if(populat==null)
                continue;

            String emp_string =
                    String.format("%-1s %-14s %-19s  %-3s%% %20s %-3s%% %22s %-1s",
                            "|",populat.getName(), populat.getPopulationtotal(), populat.getPopulationin(),"",populat.getPopulationout(),"","|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
    //-------------------------------------------------------------------------------------------------------------------
    public void displaypopulationlivingincitiesornotregion(ArrayList<Populationcities> popul){
        if (popul == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-14s %-19s  %-23s  %-20s %-1s  ","|","Region","Population Total","People living in Cities","People not living in cities ","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all Population in the list
        for (Populationcities populat : popul) {
            if(populat==null)
                continue;

            String emp_string =
                    String.format("%-1s %-14s %-19s  %-3s%% %20s %-3s%% %22s %-1s",
                            "|",populat.getRegion(), populat.getPopulationtotal(), populat.getPopulationin(),"",populat.getPopulationout(),"","|");
            System.out.println(emp_string);
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }
//-------------------------------------------------------------------------------------------------------------------
    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

}
