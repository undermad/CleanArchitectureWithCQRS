package example.exceptions;

public class EmptyPackingListIdException extends PackItException{
    public EmptyPackingListIdException() {
        super("Packing list id can not be empty");
    }
}
