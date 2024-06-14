package example.value_objects;

import example.exceptions.EmptyPackingListItemException;

public record PackingItem(String name, String quantity, Boolean isPacked) {

    public PackingItem {
        if(name.isBlank()) throw new EmptyPackingListItemException();
    }
}
