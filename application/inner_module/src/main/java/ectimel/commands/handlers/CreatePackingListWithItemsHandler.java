package ectimel.commands.handlers;

import ectimel.commands.CreatePackingListWithItems;
import ectimel.exceptions.PackingListAlreadyExistException;
import ectimel.exceptions.WeatherNotFoundException;
import ectimel.services.PackingListReadService;
import ectimel.services.WeatherService;
import example.commands.CommandHandler;
import example.factories.PackingListFactory;
import example.repository.PackingListRepository;
import example.value_objects.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CreatePackingListWithItemsHandler implements CommandHandler<CreatePackingListWithItems> {

    private final PackingListRepository repository;

    private final PackingListFactory packingListFactory;

    private final PackingListReadService readService;

    private final WeatherService weatherService;

    public CreatePackingListWithItemsHandler(PackingListRepository repository, PackingListFactory packingListFactory, PackingListReadService readService, WeatherService weatherService) {
        this.repository = repository;
        this.packingListFactory = packingListFactory;
        this.readService = readService;
        this.weatherService = weatherService;
    }


    @Override
    public CompletableFuture<Void> handleAsync(CreatePackingListWithItems command) {

        return CompletableFuture.runAsync(() -> {

            if (readService.existsByNameAsync(command.name()).join()) {
                throw new PackingListAlreadyExistException(command.name());
            }

            var localization = new Localization(command.localization().city(), command.localization().country());


            var weather = weatherService.GetWeatherAsync(localization).join();

            if (weather == null) {
                throw new WeatherNotFoundException(localization);
            }

            var packingList = packingListFactory.createWithDefaultItems(
                    new PackingListId(command.id()),
                    new PackingListName(command.name()),
                    localization,
                    new TravelDays(command.days()),
                    command.gender(),
                    new Temperature(weather.temperature()));

            repository.addAsync(packingList).join();
        });
    }
}
