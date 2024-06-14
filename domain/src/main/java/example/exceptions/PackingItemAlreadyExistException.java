package example.exceptions;

import example.value_objects.PackingItem;
import example.value_objects.PackingListName;

public class PackingItemAlreadyExistException extends PackItException{
    public PackingItemAlreadyExistException(PackingListName list, PackingItem item) {
        super("Packing list " + list.value() + " already defined item '" + item.name() + "'");
    }
}
