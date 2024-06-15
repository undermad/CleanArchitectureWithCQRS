package example.value_objects;

import example.exceptions.EmptyPackingListItemException;

public record PackingItem(String name, Integer quantity, Boolean isPacked) {

    public PackingItem {
        if (name.isBlank()) throw new EmptyPackingListItemException();
        quantity = 0;
    }
    
    public PackingItem(PackingItem other, Boolean isPacked){
        this(other.name, other.quantity(), isPacked);
    }

}
