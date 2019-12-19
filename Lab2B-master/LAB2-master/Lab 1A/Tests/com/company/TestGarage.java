package com.company;

import Model.Garage;
import Model.Saab95;
import Model.Vehicle;
import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestGarage {

//C:\Users\izabe\Downloads\LAB2-master

    @Test
    public void testUseGarage(){
        Garage <Volvo240> g = new Garage<Volvo240>(3);
        Volvo240 car = new Volvo240(0,0);

        g.useGarage(car);
        assertTrue(g.carsInGarage.size() > 0);
    }

    /*@Test
    public void testWrongCarInGarage(){
        Garage <Volvo240> g = new Garage<Volvo240>(3);
        Saab95 car = new Saab95(startingPosition);

        g.useGarage(car);
        assertEquals(0, g.carsInGarage.size());
    }
     */

    @Test
    public void testUnloadCarGarage(){
        Garage<Vehicle> g = new Garage<Vehicle>(5);
        Saab95 car = new Saab95(0,0);

        g.useGarage(car);
        g.unloadCarGarage(car);

        assertEquals(0, g.carsInGarage.size());
    }
}
