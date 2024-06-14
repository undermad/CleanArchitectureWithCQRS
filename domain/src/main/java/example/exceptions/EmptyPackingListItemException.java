package example.exceptions;

public class EmptyPackingListItemException extends PackItException{
    public EmptyPackingListItemException() {
        super("List item can not be empty.");
    }
}
