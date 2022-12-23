package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        // Create new Application
        App app = new App();

        // Connect to database

        if(args.length < 1){
            app.connect("localhost:33060", 30000);
        }else{
            app.connect(args[0], Integer.parseInt(args[1]));
        }


        //All the countries in the world organised by largest population to smallest.
        //ArrayList<Country> cou = app.getCountryContinent();
        //app.displayCountry(cou);




        //All the cities in the world organised by largest population to smallest.
        ArrayList<City> cty = app.getCityWorld();
        app.displayCity(cty);


        //get ID for capitalcity
        //ArrayList<City> cty = app.getcapitalcitiesintheregion();
        //displaycapital city
        //app.displaycapitalcity(cty);


        // Disconnect from database
        app.disconnect();
    }


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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Population"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = 'Europe' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Population"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = 'Central Europe' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Population"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
                cou.add(ct);
            }
            return cou;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country with region details");
            return null;
        }
    }
    public void displayCountry(ArrayList<Country> cou) {
        if (cou == null)
        {
            System.out.println("No Country found");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-10s %-10s", "Code", "Name", "Continent", "Region", "Capital", "Population"));
        //
        for (Country ct : cou) {
            if(ct==null)
                continue;

            String city_string =
                    String.format("%-10s %-15s %-20s %-8s %-10s %-10s",
                            ct.getCode(), ct.getName(), ct.getContinent(), ct.getRegion(), ct.getCapital(), ct.getPopulation());
            System.out.println(city_string);
        }
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
                    "SELECT ID, Name, District, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cty = new ArrayList<City>();
            while (rset.next()) {
                City ct = new City();
                ct.setID(rset.getInt("ID"));
                ct.setName(rset.getString("Name"));
                ct.setDistrict(rset.getString("District"));
                ct.setPopulation(rset.getInt("Population"));
                cty.add(ct);
            }
            return cty;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }

    public void displayCity(ArrayList<City> cty) {
        if (cty == null) {
            System.out.println("No City");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "ID", "Name", "District", "Population"));
        //
        for (City ct : cty) {
            if (ct == null)
                continue;

            String city_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            ct.getID(), ct.getName(), ct.getDistrict(), ct.getPopulation());
            System.out.println(city_string);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
        //get capital cities in the world
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
            ArrayList<City> cty = new ArrayList<City>();
            while (rset.next()) {
                City ct = new City();
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                ct.setCountryCode(rset.getString("city.CountryCode"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    public void displaycapitalcity(ArrayList<City> cty) {
        if (cty == null)
        {
            System.out.println("No Capital City");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s", "Population", "Name","Country"));
        // Loop over all employees in the list
        for (City ct : cty) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-10s %-15s %-20s ",
                            ct.getPopulation(), ct.getName(), ct.getCountryCode());
            System.out.println(emp_string);
        }
    }


    //-----------------------------------------------------------------------------------------------------------------------------------
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
            ArrayList<City> cty = new ArrayList<City>();
            while (rset.next()) {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
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
            ArrayList<City> cty = new ArrayList<City>();
            while (rset.next()) {
                City ct = new City();
                ct.setID(rset.getInt("city.ID"));
                ct.setName(rset.getString("city.Name"));
                ct.setPopulation(rset.getInt("city.Population"));
                cty.add(ct);
            }
            return cty;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }


    //-----------------------------------------------------------------------------------------------------------------------------------
    //display capital cities in the world

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
