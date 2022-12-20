package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


public class Testingazrael
{
    public static void main(String[] args)
    {
        // Create new Application
        App app = new App();

        // Connect to database
        app.connect();
        //get ID
        ArrayList<City> city = app.getCity();
        System.out.println(city.size());
        // Disconnect from database
        app.disconnect();
    }


    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */

    public ArrayList<City> getCity()
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT ID, Name, District, Population "
                            + "FROM city " ;
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> world = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.ID=rset.getInt("ID");
                cty.Name=rset.getString("Name");
                cty.District=rset.getString("District");
                cty.Population=rset.getInt("Population");
                world.add(cty);
            }
            return world;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    /**

     public City getCity(int ID)
     {
     try
     {
     // Create an SQL statement
     Statement stmt = con.createStatement();
     // Create string for SQL statement
     String strSelect =
     "SELECT ID, Name, District, Population "
     + "FROM city "
     + "WHERE ID = " + ID;
     // Execute SQL statement
     ResultSet rset = stmt.executeQuery(strSelect);
     // Return new employee if valid.
     // Check one is returne
     if (rset.next())
     {
     City cty = new City();
     cty.ID=rset.getInt("ID");
     cty.Name=rset.getString("Name");
     cty.District=rset.getString("District");
     cty.Population=rset.getInt("Population");
     return cty;
     }
     else
     return null;
     }
     catch (Exception e)
     {
     System.out.println(e.getMessage());
     System.out.println("Failed to get City details");
     return null;
     }
     }
     public void displayCity(City cty)
     {
     if (cty != null)
     {
     System.out.println(
     cty.ID + " "
     + "Name:" + cty.Name+ " "
     + "District:" + cty.District+" "
     + "Population:"+ cty.Population+
     "\n");
     }
     }




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
}


