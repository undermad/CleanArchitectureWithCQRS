package example.value_objects;

import example.exceptions.EmptyPackingListItemException;

import java.util.UUID;

public record PackingItem(UUID uuid, String name, Integer quantity,
                          Boolean isPacked) {

    public PackingItem {
        if (name.isBlank()) throw new EmptyPackingListItemException();
    }

    public PackingItem(String name, Integer quantity, Boolean isPacked) {
        this(UUID.randomUUID(), name, quantity, isPacked);
    }


    public PackingItem(PackingItem other, Boolean isPacked) {
        this(other.uuid, other.name, other.quantity(), isPacked);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PackingItem o = (PackingItem) obj;
        return this.name.equals(o.name) || this.uuid.equals(o.uuid);
    }
}
