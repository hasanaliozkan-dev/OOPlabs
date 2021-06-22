package vehicle.motorbikes;
import vehicle.Vehicle;
import exceptions.InvalidOptionChoice;;
public abstract class MotorBike extends Vehicle {

    //If the user want to a full package MotorBike he or she can use this contructor.
    public MotorBike(boolean full) throws InvalidOptionChoice {
       this.setAbs(true);
       this.setSeatHeating(true);
   }
    public MotorBike() {

    }
    @Override
    public int cost() {
       /* int total_optional_cost = 0;
        if (this.getAbs())
            total_optional_cost +=5000;
        if (this.getSeatHeating())
            total_optional_cost +=2000;*/
        return (this.getAbs()?5000:0) + (this.getSeatHeating()?2000:0);
    }

    @Override
    public String toString() {
        if(!(this.getSeatHeating()||this.getAbs()))
            return this.getName()
                    +"'s price is ";
        return super.toString()
                +(this.getSeatHeating()?" Seat Heating":"")
                + " having a total price of ";
    }
}
