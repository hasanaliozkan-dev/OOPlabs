package vehicle.cars;
import vehicle.Vehicle;
import exceptions.InvalidOptionChoice;
public abstract class Car extends Vehicle {
    //If the user want to a full package Car he or she can use this contructor.
    public Car(boolean full) throws InvalidOptionChoice {
        this.setAbs(true);
        this.setAirBag(true);
        this.setMusicSystem(true);
        this.setSunroof(true);
    }
    public Car() {
    }

    @Override
    public int cost() {
        /*int total_optional_cost =0;
        if (this.getAbs())
            total_optional_cost += 5000;
        if (this.getAirBag())
            total_optional_cost +=3000;
        if(this.getMusicSystem())
            total_optional_cost+=1000;
        if(this.getSunroof())
            total_optional_cost += 2000;*/
        return (this.getAbs()?5000:0)
                +(this.getAirBag()?3000:0)
                +(this.getMusicSystem()?1000:0)
                +(this.getSunroof()?2000:0);
    }

    @Override
    public String toString() {
        if (!(this.getAirBag()||this.getSunroof()||this.getMusicSystem()||this.getAbs()))
            return this.getName()
                    +"'s price is ";

        return super.toString()
                +(this.getMusicSystem()?" Music System,":"")
                +(this.getAirBag()?" Air Bag ":"")
                +(this.getSunroof()?" Sunroof":"")
                +" having a total price of ";
    }
}
