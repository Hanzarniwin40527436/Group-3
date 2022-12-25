package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        /** Create new Application */
        App app = new App();

        /** Connect to database */
        if(args.length < 1){
            app.connect("localhost:33060", 30000);
        }else{
            app.connect(args[0], Integer.parseInt(args[1]));
        }

        /** All the countries in the world organised by largest population to smallest. */
        //ArrayList<Country> cou = app.getCountryWorld();
        //ArrayList<Country> cou = app.getCountryContinent();
        //ArrayList<Country> cou = app.getCountryRegion();

        /** the top N populated countries by the user. */
        //ArrayList<Country> cou = app.getTopNPopulatedCountriesInTheWorld();
       //<Country> cou = app.getTopNPopulatedCountriesInTheContinent();
        //ArrayList<Country> cou = app.getTopNPopulatedCountriesInTheRegion();


        /** All the cities in the world organised by largest population to smallest. */
        //ArrayList<City> cty = app.getCityWorld();

        /** The top N populated cities provided by the user*/
        //ArrayList<City> cty = app.getTopNPopulatedCityInTheWorld();



        /** All the capital cities in the world organized by largest population to smallest */
        //ArrayList<City> capty = app.getcapitalcitiesintheworld();
        //ArrayList<City> capty = app.getcapitalcitiesinthecontinent();
        //ArrayList<City> capty = app.getcapitalcitiesintheregion();

        /** the top N populated capital cities in the world where N is provided by the user. */
        //ArrayList<City> capty = app.getTOPNcapitalcitiesintheworld();
        //ArrayList<City> capty = app.getTOPNcapitalcitiesinthecontinent();
        //ArrayList<City> capty = app.getTOPNcapitalcitiesintheregion();
        ArrayList<Country> wcou = app.WorldPopulation();
        ArrayList<Country> ccou = app.ContinentPoupulation();
        ArrayList<Country> recou = app.RegionPoupulation();
        /** display country */
        //app.displayCountry(cou);

        /** display city */
       //app.displayCity(cty);

        /** display capital city */
        //app.displaycapitalcity(capty);

        app.displayPopulation(wcou);
        app.displayContinentPopulation(ccou);
        app.displayRegionPopulation(recou);


        /** Disconnect from database */
        app.disconnect();
    }

    //-------------------------------------------------------------------------------------------------------------------
    /** Connection */
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
                ct.setRegion(rset.getString("Region"));
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
                            + "WHERE Continent = 'North America' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
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
                ct.setRegion(rset.getString("Region"));
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "+
                            "FROM country "+
                            "ORDER BY Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "+
                            "FROM country "+"WHERE Continent = 'North America' "+
                            "ORDER BY Population DESC "+ "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
                cou.add(ct);
            }
            return cou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details of populated countries in the contient");
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
                    "SELECT Code, Name, Continent, Region, Population, Capital "+
                            "FROM country "+"WHERE Region='Southern Europe' "+ "ORDER BY Population DESC "+
                             "LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> cou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setCode(rset.getString("Code"));
                ct.setName(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));
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
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-4s %-1s %-45s %-1s %-15s %-1s %-25s %-1s %-8s %-1s %-12s %-1s","|", "Code", "|","Name", "|","Continent","|", "Region", "|","Capital","|", "Population","|"));
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        //
        for (Country ct : cou) {
            if(ct==null)
                continue;

            String city_string =
                    String.format("%-1s %-4s %-1s %-45s %-1s %-15s %-1s %-25s %-1s %-8s %-1s %-12s %-1s",
                            "|",ct.getCode(), "|",ct.getName(), "|",ct.getContinent(),"|",ct.getRegion(), "|",ct.getCapital(),"|", ct.getPopulation(),"|");
            System.out.println(city_string);

        }
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
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
                    "SELECT ID, Name, Population, District "+
                            "FROM city " +
                            "ORDER BY Population DESC " + "LIMIT 5";
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
            ArrayList<City> cty = new ArrayList<City>();
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
            ArrayList<City> cty = new ArrayList<City>();
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
            ArrayList<City> cty = new ArrayList<City>();
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
            ArrayList<City> cty = new ArrayList<City>();
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
            ArrayList<City> cty = new ArrayList<City>();
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
            ArrayList<City> cty = new ArrayList<City>();
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

    public ArrayList<Country> WorldPopulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) "+ "FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> wcou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setPopulation(rset.getInt("Population"));
                wcou.add(ct);
            }
            return wcou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital Cities details");
            return null;
        }
    }

    public void displayPopulation(ArrayList<Country> wcou){
        if (wcou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format( "%-35s","Population"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all employees in the list
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
    public ArrayList<Country> ContinentPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Continent, SUM(Population) "+ "FROM country "+ "GROUP BY Continent";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> ccou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setContinent(rset.getString("Continent"));
                ct.setPopulation(rset.getInt("Population"));
                ccou.add(ct);
            }
            return ccou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Continent Population details");
            return null;
        }
    }
    public void displayContinentPopulation(ArrayList<Country> ccou){
        if (ccou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s","|","Continent","|","Population","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all employees in the list
        for (Country ct : ccou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s",
                            "|",ct.getContinent(),"|",ct.getPopulation(),"|","|");
            System.out.println(emp_string);

        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    public ArrayList<Country> RegionPoupulation(){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Region, SUM(Population) "+ "FROM country "+ "GROUP BY Region";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> recou = new ArrayList<Country>();
            while (rset.next()) {
                Country ct = new Country();
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                recou.add(ct);
            }
            return recou;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Region Population details");
            return null;
        }
    }
    public void displayRegionPopulation(ArrayList<Country> recou){
        if (recou == null)
        {
            System.out.println("No Population");
            return;
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println(String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s","|","Region","|","Population","|"));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        // Loop over all employees in the list
        for (Country ct : recou) {
            if(ct==null)
                continue;
            String emp_string =
                    String.format("%-1s %-10s %-1s %-35s %-1s %-38s %-1s",
                            "|",ct.getRegion(),"|",ct.getPopulation(),"|","|");
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
