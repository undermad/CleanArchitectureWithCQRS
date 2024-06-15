package example.value_objects;

import example.exceptions.InvalidTemperatureException;

public record Temperature(Double value) {

    public Temperature {
        if (value < -100 || value > 100) {
            throw new InvalidTemperatureException(value);
        }
    }

    public static String convertToString(Temperature temperature) {
        return temperature.value().toString();
    }
    
}
