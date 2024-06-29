package ectimel.exceptions;

import example.exceptions.PackItException;

public class InvalidUUIDException extends PackItException {
    public InvalidUUIDException(String uuidString) {
        super("UUID: " + uuidString + " is not valid.");
    }
}
