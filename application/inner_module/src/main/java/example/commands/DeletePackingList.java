package example.commands;

import java.util.UUID;

public record DeletePackingList(UUID packingListId) implements Command {
}
