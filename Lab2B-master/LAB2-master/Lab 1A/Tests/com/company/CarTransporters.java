package com.company;

import Model.Truck;
import Model.Scania;
import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTransporters {



    @Test
    public void testLiftFlatbed() {
        Scania t = new Scania(0,0, 15, 20);

        t.liftFlatbed();
        assertTrue(t.getAngle() < 15);
    }

    @Test
    public void testLowerFlatbed(){
        Scania t = new Scania(0,0, 0, 20);

        t.lowerFlatbed();
        assertTrue(t.getAngle() > 0);
    }

    @Test
    public void testMove(){
        Scania t = new Scania(0,0, 0, 10);
        t.startEngine();
        t.move();
        assertTrue(t.getCurrentSpeed() > 0);
    }

    @Test
    public void testNotMove(){
        Scania t = new Scania(0,0, 10, 10);

        t.move();
        assertEquals(0, t.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testTruckLoadCar(){
        Truck t = new Truck(0,0, 3, true);
        Volvo240 v = new Volvo240(0,0);

        t.startEngine();
        t.move();
        t.loadCar(v);

        assertTrue(t.carsInTruck.isEmpty());
    }

    @Test
    public void testTruckCanLoadCar(){
        Truck t = new Truck(0,0, 3, true);
        Volvo240 v = new Volvo240(0, 0.5);

        t.loadCar(v);

        assertFalse(t.carsInTruck.isEmpty());
    }

   /* @Test
    public void testCarMoveInTruck(){
        Truck t = new Truck(0,0, 3, true);
        Volvo240 v = new Volvo240(0, 0.5);

        t.loadCar(v);
        v.move();

        assertTrue();               FIXA TESTET!
    }

    */

    @Test
    public void testUnloadCarTruck(){
        Truck t = new Truck(0,0, 3, true);
        Volvo240 v = new Volvo240(0, 0.5);

        t.loadCar(v);
        t.unloadCar();

        assertTrue(t.carsInTruck.isEmpty());
    }

    @Test
    public void testUnloadCarTruckMove(){
        Truck t = new Truck(0,0, 3, true);
        Volvo240 v = new Volvo240(0, 0.5);

        t.loadCar(v);
        t.move();
        t.unloadCar();

        assertEquals(1, t.carsInTruck.size());
    }
}
