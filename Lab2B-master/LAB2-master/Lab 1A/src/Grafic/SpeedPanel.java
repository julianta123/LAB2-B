package Grafic;

import Model.Vehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;


public class SpeedPanel extends JPanel {

    private JLabel carLabel;
    private HashMap<Vehicle, JLabel> vehicleJLabelHashMap = new HashMap<>();

    public SpeedPanel(int x, int y, ArrayList<Vehicle> cars) {

    }

    public void updateLabel(Vehicle car){
        JLabel carLabel = vehicleJLabelHashMap.get(car);
        carLabel.setText(car.getModelName() + " Current speed is " + Math.abs(car.getCurrentSpeed()));
    }

    public void removeLabel(Vehicle car){
        JLabel carLabel =vehicleJLabelHashMap.get(car);
        vehicleJLabelHashMap.remove(car);
        this.remove(carLabel);
    }

    public void addLabel(Vehicle car){
        JLabel carLabel = new JLabel();
        vehicleJLabelHashMap.put(car, carLabel);
        this.add(carLabel);
        updateLabel(car);
    }
}

