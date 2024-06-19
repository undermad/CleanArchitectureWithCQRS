package example.exceptions;

import java.util.UUID;

public class PackingListDoesntExistException extends PackItException {
    public PackingListDoesntExistException(UUID packingListId) {
        super("Packing list with id: " + packingListId + " doesn't exist.");
    }
}
