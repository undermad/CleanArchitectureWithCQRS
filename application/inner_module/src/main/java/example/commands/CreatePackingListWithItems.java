package example.commands;

import example.constants.Gender;

import java.util.UUID;

public record CreatePackingListWithItems(UUID id, String name, short days, Gender gender, LocalizationWriteModel localization) implements Command {
}
