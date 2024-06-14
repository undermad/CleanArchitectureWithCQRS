package example.exceptions;

public class EmptyPackingListNameException extends PackItException {
    
    public EmptyPackingListNameException() {
        super("Packing list name can not be empty.");
    }
    
}
