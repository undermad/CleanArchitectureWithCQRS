package ectimel.exception;

import example.exceptions.PackItException;

import java.util.UUID;

public class PackingListNotFoundException extends PackItException {
    
    public PackingListNotFoundException(UUID uuid) {
        super("Packing list with id: " + uuid + " not found.");
    }
}
