package exceptions;

public class InvalidOptionChoice extends Exception{
    //If the user choose an invalid choice for example a motorbike can not have a sunroof.
    //We throw this exception.
    public InvalidOptionChoice(String message) { super(message); }
}
