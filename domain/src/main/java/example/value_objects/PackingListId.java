package example.value_objects;

import example.exceptions.EmptyPackingListIdException;

import java.util.UUID;

public record PackingListId(UUID value) {

    public PackingListId {
        if (value == null) throw new EmptyPackingListIdException();
    }
    
    public static PackingListId create(UUID uuid){
        return new PackingListId(uuid);
    }
}
