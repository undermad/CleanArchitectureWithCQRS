package example.factories;

import example.constants.Gender;
import example.entities.PackingList;
import example.value_objects.*;

public class PackingListFactoryImpl implements PackingListFactory{
    @Override
    public PackingList create(PackingListId packingListId, PackingListName packingListName, Localization localization) {
        return null;
    }

    @Override
    public PackingList createWithDefaultItems(PackingListId packingListId, PackingListName packingListName, Localization localization, TravelDays travelDays, Gender gender, Temperature temperature) {
        return null;
    }
}
