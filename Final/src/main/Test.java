package main;

import exceptions.InvalidOptionChoice;
import inventory.Inventory;
import vehicle.cars.*;
import vehicle.motorbikes.*;

public class Test {
    public static void main(String[] args)  {
        Inventory inventory = new Inventory();

        //Sivic with ABS, Music System, Air Bag optional having a total price of 59000 TL
        Car car = new Sivic();
        car.setAbs(true);//Add ABS for Sivic I didn't throw any exception for it since it is included both type.
        try {
            car.setMusicSystem(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        try {
            car.setAirBag(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        inventory.add(car);
        //Sivic with ABS, Sunroof optional having a total price of 57000 TL
        car = new Sivic();
        car.setAbs(true);
        try {
            car.setSunroof(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        inventory.add(car);

        //Sity with Music System, Sunroof optional having a total price of 43000 TL
        car = new Sity();
        try {
            car.setMusicSystem(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        try {
            car.setSunroof(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        inventory.add(car);

        //Racer with ABS, Seat Heating optional having a total price of 67000 TL
        MotorBike motorBike;
        try {
            motorBike = new Racer(true); //It is actually a full package.
            inventory.add(motorBike);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }


        //Scooter with Seat Heating optional having a total price of 22000 TL
        motorBike = new Scooter();
        try {
            motorBike.setSeatHeating(true);
        } catch (InvalidOptionChoice invalidOptionChoice) {
            System.out.println(invalidOptionChoice);
        }
        inventory.add(motorBike);
        //Print out all inventory.
        System.out.println(inventory);

    }

}
