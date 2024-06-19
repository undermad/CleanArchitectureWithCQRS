package example.commands;

import java.util.UUID;

public record RemovePackingItem(UUID packingListId, String packingItemName) implements Command {
}
