package vehicle.cars;
import exceptions.InvalidOptionChoice;

public class Sivic extends Car {

    //If the user want to a full package Sivic he or she can use this contructor.
    public Sivic(boolean full) throws InvalidOptionChoice {
        super(full);
        this.setCost(50000);
        this.setName("Sivic");
    }
    public Sivic() {

        this.setCost(50000);
        this.setName("Sivic");
    }


    @Override
    public int cost() {
        return this.getCost() + super.cost();
    }

    @Override
    public String toString() {
        return super.toString() + this.cost() +" TL";
    }
}
