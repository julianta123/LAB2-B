import Controller.CarController;
import Grafic.CarView;
import Grafic.DrawPanel;
import Grafic.SpeedPanel;
import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static final int delay = 50;

    public static void main(String[] args) {

        ArrayList<Vehicle> cars = new ArrayList<>();
        CarController cc = new CarController();
        CarView carView = new CarView("CarSim 1.0", cars);

        cc.setAllListeners(cars, carView, carView.speedPanel);

        Timer timer = new Timer(delay, (actionEvent) -> {
            for (Vehicle car : cars) {
                car.move();
                carView.speedPanel.updateLabel(car);
                carView.drawPanel.populateCarImageMap(cars);
                carView.drawPanel.repaint();
                if (car.getX() > carView.getWidth() - 120) {
                    car.currentDirection = Vehicle.direction.WEST;
                } else if (car.getX() < 0) {
                    car.currentDirection = Vehicle.direction.EAST;
                }
            }
        });

        timer.start();


    }
}
