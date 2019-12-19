package Grafic;

import Model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {

    private HashMap<String, BufferedImage> imageMap = new HashMap<>();
    List<Vehicle> cars;

    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.cars = cars;
        populateCarImageMap(cars);
    }

    public void populateCarImageMap(ArrayList<Vehicle> cars){
        for(Vehicle c : cars){
            String modelName =c.getModelName();
            BufferedImage carImage = null;
            try{
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/Grafic/pics/" + modelName + ".jpg"));
            }catch (IOException e){
                e.printStackTrace();
            }
            imageMap.put(c.getModelName(), carImage);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle v : cars){
            g.drawImage(imageMap.get(v.getModelName()), (int) v.getX(), (int) v.getY(), null);
        }
    }
}