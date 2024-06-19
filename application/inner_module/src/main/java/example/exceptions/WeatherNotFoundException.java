package example.exceptions;

import example.value_objects.Localization;

public class WeatherNotFoundException extends PackItException {
    public WeatherNotFoundException(Localization localization) {
        super("Weather for localization: " + localization.city() + ", " + localization.country() + " not found.");
    }
}
