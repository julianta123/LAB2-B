package Model;

import Model.Vehicle;

import java.awt.*;
import java.util.Stack;

/**The Truck class describes what the trucks methods are.
 * As it also extends Vehicle, the truck class has the same method as found in Vehicle
 */

public class Truck extends Vehicle {

    private int maxNCars;
    private boolean rampIsUp = true;
    private double maxCarLength;
    private double maxCarWidth;
    public Stack<Vehicle> carsInTruck = new Stack<>();


    /**Describes the trucks attributes
     *
     * @param maxNCars max number of cars the truck can load
     * @param rampIsUp says if the trucks ramp is up
     */

    public Truck(double x, double y, int maxNCars, boolean rampIsUp) {
        super(2, 125, Color.BLACK, "ToyotaX100", 9, 2, true,
                x,y);
        this.maxNCars = 3;
        this.rampIsUp = rampIsUp;
        this.maxCarLength = 3;
        this.maxCarWidth = 2;
    }

    /**If the truck is not moving then it raises the ramp
     *
     */

    public void raiseRamp(){
        if(getCurrentSpeed() == 0){
            rampIsUp = true;
        }
    }

    /**If the truck is not moving then it lowers the ramp
     *
     */

    private void lowerRamp(){
        if(getCurrentSpeed() == 0){
            rampIsUp = false;
        }
    }

    /**Check if the car is close enough to load.
     *
     * @param car the vehicle we want the truck to load
     * @return if the car is close to the truck or not
     */

    private boolean carIsClose(Vehicle car){
        //Position posCar = car.getPosition();
      //  Position posTruck = this.getPosition();
        double posCarX = car.getX();
        double posCarY = car.getY();
        double posTruckX = this.getX();
        double posTruckY = this.getY();

        if(posCarY > posTruckY -1 && posCarY < posTruckY +1 && car.notLoaded &&
                posCarX > posTruckX -1 && posCarX < posTruckX +1){
            return true;
        }
        return false;
    }

    /** Loads the car unto the truck
     *
     * @param car the vehicle we want the truck to load
     */

    public void loadCar(Vehicle car){
        lowerRamp();
        if(carIsClose(car) && !rampIsUp && carsInTruck.size() < maxNCars && car.getCarLength() < this.maxCarLength &&
                car.getCarWidth() < this.maxCarWidth){
            carsInTruck.push(car);
            car.notLoaded = false;
           // car.setPosition(this);


        }
    }

    /**Unloads the last car that was loaded unto the truck
     *
     */

    public void unloadCar(){
        if(!rampIsUp && carsInTruck.size() > 0){
            Vehicle v = carsInTruck.pop();
            double n = 0.9;
            v.setX(n);
            v.setY(this.getY()-0.2);
            n = n - 0.1;
            v.notLoaded = true;
        }
    }

    /**When the truck wants to move the method raises the ramp and update the cars on the trucks position
     *
     */

    @Override
    public void move(){
        raiseRamp();
        super.move();
        for(Vehicle c : carsInTruck){
            c.setY(this.getY());
            c.setX(this.getX());
        }
    }

    @Override
    public double speedFactor(double enginePower) {
        return 0;
    }
}
