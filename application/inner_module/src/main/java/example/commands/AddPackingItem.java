package example.commands;

import java.util.UUID;

public record AddPackingItem(UUID packingListId, String name, Integer quantity) implements Command {
}
