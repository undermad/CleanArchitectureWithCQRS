package example.value_objects;

import example.exceptions.EmptyPackingListNameException;

public record PackingListName(String value) {

    public PackingListName {
        if (value.isBlank()) {
            throw new EmptyPackingListNameException();
        }
    }

    public static String convertToString(PackingListName name) {
        return name.value;
    }

    public static PackingListName convertToPackingListName(String name) {
        return new PackingListName(name);
    }
    
}
    
