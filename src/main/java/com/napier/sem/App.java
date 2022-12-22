package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        // Create new Application
        App app = new App();

        // Connect to database
        app.connect();
        //All the countries in the world organised by largest population to smallest.
        //ArrayList<Country> cou = app.getCountryWorld();
        //app.displayCountry(cou);
        //All the cities in the world organised by largest population to smallest.
        //ArrayList<City> cty = app.getCityWorld();
        // app.displayCity(cty);


        //get ID for capitalcity
        ArrayList<City> cty = app.getcapitalcities();
        //displaycapital city
        app.displaycapitalcities(cty);


        // Disconnect from database
        app.disconnect();
    }


    private Connection con = null;
    public ArrayList<Country> getCountryWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country"
                            + "WHERE Region = 'Central Africa' ";
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
        //get capital cities in the world
    public ArrayList<City> getcapitalcities() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population"
                            + "FROM city, country"
                            + "WHERE city.CountryCode= country.Code"
                            + "ORDER BY Population DESC";
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
    //display capital cities in the world
    public void displaycapitalcities(ArrayList<City> cty) {
        if (cty == null)
        {
            System.out.println("No Capital City");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s", "ID", "Name","Population"));
        // Loop over all employees in the list
        for (City ct : cty) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            ct.getID(), ct.getName(), ct.getPopulation());
            System.out.println(emp_string);
        }
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
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
