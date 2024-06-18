package ectimel.services;

import ectimel.dto.external.WeatherDto;
import example.value_objects.Localization;

import java.util.concurrent.CompletableFuture;

public interface WeatherService {
    CompletableFuture<WeatherDto> GetWeatherAsync(Localization localization);
}
