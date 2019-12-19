package Model;

import Model.Vehicle;

import java.awt.*;

public class Saab95 extends Vehicle {

    private boolean turboOn;

    /**Specifies the cars attributes.
     *
     */

    public Saab95(double x, double y) {
        super(2, 125, Color.red, "Saab95", 2.8, 1.3, true,
                x, y);
        stopEngine();
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    /**This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */
    @Override
    public double speedFactor(double enginePower) {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}