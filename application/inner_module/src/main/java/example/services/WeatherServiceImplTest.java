package example.services;

import example.dto.external.WeatherDto;
import example.value_objects.Localization;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class WeatherServiceImplTest implements WeatherService {
    @Override
    public CompletableFuture<WeatherDto> GetWeatherAsync(Localization localization) {
        return null;
    }
}
