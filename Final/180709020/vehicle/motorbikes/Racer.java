package vehicle.motorbikes;
import exceptions.InvalidOptionChoice;

public class Racer extends MotorBike{

    //If the user want to a full package Racer he or she can use this contructor.
    public Racer(boolean full) throws InvalidOptionChoice {
        super(full);
        this.setCost(60000);
        this.setName("Racer");
    }

    public Racer() {
        this.setCost(60000);
        this.setName("Racer");
    }

    @Override
    public int cost() {
        return this.getCost() + super.cost();
    }

    @Override
    public String toString() {
        return super.toString()+this.cost() + " TL";
    }
}
