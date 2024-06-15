package example.exceptions;

public class PackingItemNotFoundException extends PackItException{
    public PackingItemNotFoundException(String itemName) {
        super("Packing item: " + itemName + " not found.");
    }
}
