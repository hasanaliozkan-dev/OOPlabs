package vehicle.cars;
import exceptions.InvalidOptionChoice;


public class Sity extends Car {
    //If the user want to a full package Sity  he or she can use this contructor.
    public Sity(boolean full) throws InvalidOptionChoice {
        super(full);
        this.setCost(40000);
        this.setName("Sity");
    }

    public Sity(){
     this.setCost(40000);
     this.setName("Sity");
    }

    @Override
    public int cost() {

        return this.getCost() + super.cost();
    }

    @Override
    public String toString() {
        return super.toString() + this.cost() + " TL";
    }
}
