package example.factories;

import example.constants.Gender;
import example.entities.PackingList;
import example.value_objects.*;

public interface PackingListFactory {
    PackingList create(PackingListId packingListId, PackingListName packingListName, Localization localization);

    PackingList createWithDefaultItems(PackingListId packingListId, PackingListName packingListName, Localization localization, TravelDays travelDays, Gender gender, Temperature temperature);
}
