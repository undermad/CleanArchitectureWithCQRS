package example.commands;

import java.util.UUID;

public record RemovePackingList(UUID packingListId) implements Command {
}
