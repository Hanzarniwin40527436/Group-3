package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App app = new App();

        // Connect to database
        app.connect();
        //get ID
        ArrayList<City> cty = app.getCity();
        app.displayCity(cty);

        // Disconnect from database
        app.disconnect();
    }


    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    public ArrayList<City> getCity()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cty = new ArrayList<City>();
            while (rset.next())
            {
                City ct = new City();
                ct.ID=rset.getInt("ID");
                ct.Name=rset.getString("Name");
                ct.CountryCode=rset.getString("CountryCode");
                ct.District=rset.getString("District");
                ct.Population=rset.getInt("Population");
                cty.add(ct);
            }
            return cty;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }
    public void displayCity(ArrayList<City> cty)
    {
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "ID", "Name", "CountryCode", "District", "Population"));
        // Loop over all employees in the list
        for (City ct : cty)
        {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            ct.ID, ct.Name, ct.CountryCode, ct.District, ct.Population);
            System.out.println(emp_string);
        }

    }










}

