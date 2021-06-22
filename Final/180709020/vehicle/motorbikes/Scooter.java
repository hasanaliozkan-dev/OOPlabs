package vehicle.motorbikes;
import exceptions.InvalidOptionChoice;

//If the user want to a full package Scooter he or she can use this contructor.
public class Scooter extends MotorBike{
    public Scooter(boolean full) throws InvalidOptionChoice {
        super(full);
        this.setCost(20000);
        this.setName("Scooter");
    }

    public Scooter() {
        this.setCost(20000);
        this.setName("Scooter");
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
