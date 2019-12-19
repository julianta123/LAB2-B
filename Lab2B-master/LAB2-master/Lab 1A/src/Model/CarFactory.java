package Model;

import java.util.ArrayList;
import java.util.Random;


public class CarFactory {

    static Random rand = new Random();

    public static Vehicle randomVehicle(ArrayList<Vehicle> cars){
        int rand1 = rand.nextInt(3);
        Vehicle v = null;
        if (rand1 == 0){
            v = createSaab95(cars);
        }
        else if (rand1 ==1) {
            v = createScania(cars);
        }
        else if (rand1 == 2) {
            v = createVolvo240(cars);
        }
        return v;
    }

    public static int addY(ArrayList<Vehicle> cars){
        return cars.size() * 70 + 100;
    }

    public static Vehicle createSaab95 (ArrayList<Vehicle> cars){
        return new Saab95(0,addY(cars));
    }

    public static Vehicle createVolvo240(ArrayList<Vehicle> cars){ return new Volvo240(0,addY(cars));}

    public static Vehicle createScania(ArrayList<Vehicle> cars){return new Scania(0,addY(cars),0,70);}


}
