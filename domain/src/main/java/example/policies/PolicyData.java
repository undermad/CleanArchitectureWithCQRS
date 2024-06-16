package example.policies;

import example.constants.Gender;
import example.value_objects.Localization;
import example.value_objects.Temperature;
import example.value_objects.TravelDays;

public record PolicyData(TravelDays days, Gender gender, Temperature temperature, Localization localization) {
}
