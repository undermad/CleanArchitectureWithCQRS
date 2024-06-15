package example.exceptions;

public class InvalidTemperatureException extends PackItException{
    public InvalidTemperatureException(Double temperature) {
        super("Value: " + temperature + " is not valid.");
    }
}
