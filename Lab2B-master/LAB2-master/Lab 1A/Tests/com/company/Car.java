package com.company;
import Model.Saab95;
import Model.Vehicle;
import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

public class Car{




    @Test
    public void testMove(){
        Vehicle c = new Volvo240(0,0);
        c.startEngine();
        c.move();
        assertTrue(c.getY() > 0);
    }


    @Test
    public void testTurnLeft(){
        Vehicle c = new Volvo240(0,0);
        c.turnLeft();

        assertSame(c.getCurrentDirection(), Vehicle.direction.WEST);
    }

    @Test
    public void testTurnRight(){
        Vehicle c = new Volvo240(0,0);
        c.turnRight();

        assertSame(c.getCurrentDirection(), Vehicle.direction.EAST);
    }

    @Test
    public void testGas(){
        Vehicle c = new Volvo240(0,0);
        double currentSpeed = c.getCurrentSpeed();

        c.gas(1);

        assertTrue(c.getCurrentSpeed() > currentSpeed );
    }

    @Test
    public void testBrake(){
        Vehicle c = new Volvo240(0,0);
        c.gas(1);
        double currentSpeed = c.getCurrentSpeed();
        c.brake(1);

        assertTrue(c.getCurrentSpeed()< currentSpeed);
    }

    @Test
    public void testStartEngine(){
        Vehicle c = new Volvo240(0,0);
        double currentSpeed = c.getCurrentSpeed();
        c.startEngine();

        assertTrue(c.getCurrentSpeed() > currentSpeed);
    }

    @Test
    public void testStopEngine(){
        Vehicle c = new Volvo240(0,0);
        c.gas(1);
        c.stopEngine();

        assertTrue(c.getCurrentSpeed() == 0);
    }

    @Test
    public void testSpeedFactorVolvo(){
        Vehicle c = new Volvo240(0,0);
        assertEquals(c.speedFactor(100), 1.25, 0.00001);
    }

    @Test
    public void testSpeedFactorSaab(){
        Vehicle c = new Saab95(0,0);
        assertEquals(c.speedFactor(125), 1.25, 0.00001 );
    }

}
