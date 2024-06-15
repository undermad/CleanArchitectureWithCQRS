package example.exceptions;

public class InvalidTravelDaysException extends PackItException {
    public InvalidTravelDaysException(Short days) {
        super("Value: " + days + " is invalid travel days.");
    }
}
