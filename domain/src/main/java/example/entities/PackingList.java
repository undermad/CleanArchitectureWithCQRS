package example.entities;

import example.domain.AggregateRoot;
import example.events.PackingItemAdded;
import example.events.PackingItemPacked;
import example.events.PackingItemRemoved;
import example.exceptions.PackingItemAlreadyExistException;
import example.exceptions.PackingItemNotFoundException;
import example.value_objects.Localization;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PackingList extends AggregateRoot<PackingListId> {

    private PackingListId uuid;
    private PackingListName name;
    private Localization localization;
    private final LinkedList<PackingItem> items = new LinkedList<>();

    public PackingList(PackingListId uuid, PackingListName name, Localization localization) {
        this.uuid = uuid;
        this.name = name;
        this.localization = localization;
    }

    public void addItem(PackingItem item) {
        boolean alreadyExist = items.contains(item);
        if (alreadyExist) throw new PackingItemAlreadyExistException(name, item);

        items.add(item);
        addEvent(new PackingItemAdded(this, item));
    }

    public void addItems(List<PackingItem> items) {
        for (var item : items) {
            addItem(item);
        }
    }

    public void packItem(String itemName) {
        var item = getItem(itemName);
        var packedItem = new PackingItem(item, true);
        findAndReplace(item, packedItem);
        addEvent(new PackingItemPacked(this, item));
    }

    public void removeItem(String itemName) {
        var item = getItem(itemName);
        items.remove(item);
        addEvent(new PackingItemRemoved(this, item));
    }

    private PackingItem getItem(String itemName) {
        var item = items.stream().filter(i -> i.name().equals(itemName))
                .toList()
                .getFirst();

        if (item == null) {
            throw new PackingItemNotFoundException(itemName);
        }

        return item;
    }

    private void findAndReplace(PackingItem target, PackingItem newValue) {
        int index = items.indexOf(target);
        if (index == -1) return;

        items.set(index, newValue);
    }
}
