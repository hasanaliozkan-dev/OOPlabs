package vehicle;

import vehicle.cars.Car;
import vehicle.motorbikes.MotorBike;
import exceptions.InvalidOptionChoice;

import java.util.HashMap;

public abstract class Vehicle {
    /**ATTRIBUTES**/
    private int cost;
    private String name;
    private boolean abs;
    private boolean musicSystem;
    private boolean airBag;
    private boolean sunroof;
    private boolean seatHeating;
    /***SETTERS***/
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAbs(boolean abs) {
        this.abs = abs;

    }
    public void setMusicSystem(boolean musicSystem) throws InvalidOptionChoice {
        if(!(this instanceof Car)){
            throw new InvalidOptionChoice("This optional is for cars.");
        }
        this.musicSystem = musicSystem;
    }

    public void setAirBag(boolean airBag) throws InvalidOptionChoice {
        if(!(this instanceof Car)){
            throw new InvalidOptionChoice("This optional is for cars.");
        }
        this.airBag = airBag;
    }

    public void setSunroof(boolean sunroof) throws InvalidOptionChoice {
        if(!(this instanceof Car)){
            throw new InvalidOptionChoice("This optional is for cars.");
        }
        this.sunroof = sunroof;
    }

    public void setSeatHeating(boolean seatHeating) throws InvalidOptionChoice {
        if (!(this instanceof MotorBike)){
            throw new InvalidOptionChoice("This optional is for motorbikes.");
        }
        this.seatHeating = seatHeating;
    }

    /***GETTERS***/
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public boolean getAbs() {
        return abs;
    }

    public boolean getMusicSystem() {
        return musicSystem;
    }

    public boolean getAirBag() {
        return airBag;
    }

    public boolean getSunroof() {
        return sunroof;
    }

    public boolean getSeatHeating() { return seatHeating; }

    //This method is abstract to force to implement all vehicles.
    public abstract int cost();


    @Override
    public String toString() {
        return this.getName() + " with"+
                (this.getAbs()?" ABS,":"");
    }
}
