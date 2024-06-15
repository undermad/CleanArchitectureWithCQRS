package example.value_objects;

import example.exceptions.InvalidTravelDaysException;

public record TravelDays(Short value) {
    public TravelDays {
        if (value < 0 || value > 365) {
            throw new InvalidTravelDaysException(value);
        }
    }

    public static String convertToString(TravelDays days) {
        return days.value().toString();
    }

}
