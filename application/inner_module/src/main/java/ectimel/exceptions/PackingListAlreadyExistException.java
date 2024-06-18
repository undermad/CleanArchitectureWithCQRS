package ectimel.exceptions;

import example.exceptions.PackItException;

public class PackingListAlreadyExistException extends PackItException {
    public PackingListAlreadyExistException(String name) {
        super("Packing list with " + name + " already exist.");
    }
}
