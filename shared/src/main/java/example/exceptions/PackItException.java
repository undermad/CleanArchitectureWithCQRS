package example.exceptions;

public abstract class PackItException extends RuntimeException {

    public PackItException(String message) {
        super(message);
    }
}
