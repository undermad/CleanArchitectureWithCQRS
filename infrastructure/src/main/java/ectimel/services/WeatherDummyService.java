package ectimel.services;

import example.dto.external.WeatherDto;
import example.services.WeatherService;
import example.value_objects.Localization;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class WeatherDummyService implements WeatherService {
    
    private Random random;

    public WeatherDummyService() {
        this.random = new Random();
    }

    @Override
    public CompletableFuture<WeatherDto> GetWeatherAsync(Localization localization) {
        return CompletableFuture.supplyAsync(() -> new WeatherDto(random.nextDouble(-10, 35)));
    }
}
