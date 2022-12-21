package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displaycity(){
        ArrayList<City> cty = new ArrayList<City>();
        City ct=new City();
        ct.ID=2331;
        ct.Name="Seoul";
        ct.District="Seoul";
        ct.Population=998161;
        cty.add(ct);

        app.displayCity(cty);

    }


}
