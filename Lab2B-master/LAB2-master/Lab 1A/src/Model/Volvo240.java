package Model;
import Model.Vehicle;

import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;


    /**Specifies the cars attributes
     *
     */

    public Volvo240(double x, double y){
        super(4, 100, Color.BLACK, "Volvo240", 2.5, 1.5,
                true, x ,y);
        stopEngine();
    }


    /**This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */
    @Override
    public double speedFactor(double enginePower){
        return enginePower * 0.01 * trimFactor;
    }
}