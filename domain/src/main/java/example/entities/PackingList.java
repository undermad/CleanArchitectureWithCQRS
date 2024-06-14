package example.entities;

import example.domain.AggregateRoot;
import example.events.PackingItemAdded;
import example.exceptions.PackingItemAlreadyExistException;
import example.value_objects.Localization;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;

@Getter
@AllArgsConstructor
public class PackingList extends AggregateRoot<PackingListId> {

    private PackingListId uuid;
    private PackingListName name;
    private Localization localization;
    private final LinkedList<PackingItem> items;

    public void addItem(PackingItem item) {
        boolean alreadyExist = items.contains(item);
        if (alreadyExist) throw new PackingItemAlreadyExistException(name, item);

        items.add(item);
        addEvent(new PackingItemAdded(this, item));
    }

    public void addItems(Iterable<PackingItem> items) {
        for (var item : items) {
            addEvent(new PackingItemAdded(this, item));
        }
    }

    public void packItem(String itemName) {
        
    }
}
