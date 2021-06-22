package inventory;

import vehicle.cars.Car;
import vehicle.motorbikes.MotorBike;
import vehicle.Vehicle;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public void add(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    /*
    public void printTheInventory(){
        int car=0,motor=0,total_cost=0;
        for (vehicle.Vehicle vehicle: inventory) {
            System.out.println(vehicle);
            if (vehicle instanceof vehicle.cars.Car)
                car++;
            if (vehicle instanceof vehicle.motorbikes.MotorBike)
                motor++;
            total_cost+=vehicle.cost();
        }
        System.out.println("TOTAL: " + inventory.size() + " Vehicles including " + car + " Cars and " + motor+
                " Motorbikes having a total price of "+ total_cost);
    }*/

    @Override
    public String toString() {
        String message = "";
        int car=0,motor=0,total_cost=0;
        for (Vehicle vehicle: inventory) {
            message += vehicle.toString() + "\n";
            if (vehicle instanceof Car)
                car++;
            if (vehicle instanceof MotorBike)
                motor++;
            total_cost+=vehicle.cost();
        }

        return message + ("TOTAL: " + inventory.size() + " Vehicles including " + car + " Cars and " + motor+
                " Motorbikes having a total price of "+ total_cost+" TL");
    }
}
