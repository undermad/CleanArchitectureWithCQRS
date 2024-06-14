package example.events;

import example.domain.DomainEvent;
import example.entities.PackingList;
import example.value_objects.PackingItem;

public record PackingItemAdded(PackingList packingList, PackingItem packingItem) implements DomainEvent {
}
