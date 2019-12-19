package Model;

import Model.Vehicle;

import java.awt.*;



public class Scania extends Vehicle {

    private double angle;
    private double amount;

    /** Describes the attributes of a truck.
     *
     * @param angle the angle of the flatbed
     * @param amount how much you want do lift or lower the flatbed
     */

    public Scania(double x, double y, double angle, double amount) {
        super(2, 90, Color.BLACK, "Scania", 5, 2, true,
                 x,y);
        this.angle = angle;
        this.amount = amount;
    }

    public double getAngle() {
        return angle;
    }

    public double getAmount() {
        return amount;
    }

    /**Lifts the flatbed
     *
     */
    public void liftFlatbed(){
        if (getCurrentSpeed() == 0 && angle > 0){
            decrementAngle();
            System.out.println("Flatbed lifted");
        }
    }

    /**Lowers the flatbed
     *
     */

    public  void lowerFlatbed(){
        if(getCurrentSpeed() == 0 && angle != 70){
            incrementAngle();
            System.out.println("Flatbed lowered");
        }
    }

    /**Decreases the angle
     *
     */

    private void decrementAngle() {
        angle = Math.max(0, angle - amount);
    }

    /**Increases the angle
     *
     */

    private void incrementAngle(){
        angle = Math.min(70, amount + angle);
    }

    /**Checks if the truck's flatbed is down or not. If it's down the truck can't move
     *
     * @return says if the truck can move or not
     */

    private boolean canTruckMove(){
        return angle == 0;
    }

    /**Check if the truck can move before it moves
     *
     */

    @Override
    public void move(){
        if(canTruckMove()){
            super.move();
        }
    }


    @Override
    public double speedFactor(double enginePower) {
        return enginePower * 0.01;
    }

}
