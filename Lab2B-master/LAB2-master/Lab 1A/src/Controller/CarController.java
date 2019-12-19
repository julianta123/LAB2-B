package Controller;
import Grafic.CarView;
import Grafic.SpeedPanel;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {


    public void gas(ArrayList<Vehicle> cars, CarView frame) {
        double gas = ((double) frame.gasAmount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    /**
     * calls the brake method for all cars once
     */

    private void breaks(ArrayList<Vehicle> cars, CarView frame ){
        double brakes = ((double) frame.gasAmount) / 100;
        for (Vehicle car : cars){
            car.brake(brakes);
        }
    }

    /**
     * calls the method that stops all cars once
     */

    private void stopAllCars(ArrayList<Vehicle> cars ){
        for( Vehicle car : cars){
            car.stopEngine();
        }
    }

    /**
     * calls the method that starts all cars once
     */

   private void startAllCars(ArrayList<Vehicle> cars ){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }

    /**
     * calls the method turbo on for Saab once
     */
    private void turboOn(ArrayList<Vehicle> cars ){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                Saab95 s = (Saab95) car;
                s.setTurboOn();
            }
        }
    }
    /**
     * calls the method turbo off for Saab once
     */

    private void turboOff(ArrayList<Vehicle> cars ){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                Saab95 s = (Saab95) car;
                s.setTurboOff();
            }
        }
    }

    /**
     *calls the liftFlatbed method for Scania
     */

   private void liftFlatbed(ArrayList<Vehicle> cars ){
        for(Vehicle car : cars){
            if (car.getModelName().equals("Scania")){
                Scania sa = (Scania) car;
                sa.liftFlatbed();
            }
        }
    }

    /**
     *calls the lowerFlatbed method for Scania
     */

    private void lowerFlatbed(ArrayList<Vehicle> cars ) {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                Scania sa =(Scania) car;
                sa.lowerFlatbed();
            }
        }
    }

    private void addCar(ArrayList<Vehicle> cars, SpeedPanel speedPanel){
        if(cars.size() < 5){
            Vehicle car = CarFactory.randomVehicle(cars);
            cars.add(car);
            speedPanel.addLabel(car);

        }
    }

    private void removeCar(ArrayList<Vehicle> cars, SpeedPanel speedPanel){
        if(!cars.isEmpty()){
            Vehicle car = cars.remove(cars.size() -1);
            speedPanel.removeLabel(car);
        }
    }

    /**
     *Sees which button is pressed and makes that happen.
     */
    public void setAllListeners(ArrayList<Vehicle> cars, CarView frame, SpeedPanel speedPanel){
        frame.startButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startAllCars(cars);
            }
        });
        frame.stopButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stopAllCars(cars);
            }
        });
        frame.lowerBedButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lowerFlatbed(cars);
            }
        });
        frame.liftBedButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                liftFlatbed(cars);
            }
        });
        frame.turboOffButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                turboOff(cars);
            }
        });
        frame.turboOnButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                turboOn(cars);
            }
        });
        frame.gasButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gas(cars, frame);
            }
        });
        frame.breakButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                breaks(cars, frame);
            }
        });
        frame.addCarButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { addCar(cars, speedPanel); }
        });
        frame.removeCarButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { removeCar(cars, speedPanel);}
        });
    }
}
