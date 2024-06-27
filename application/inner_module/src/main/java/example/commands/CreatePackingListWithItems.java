package example.commands;

import example.constants.Gender;


public record CreatePackingListWithItems(String name, short days, Gender gender, LocalizationWriteModel localization) implements Command {
}
