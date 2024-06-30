package example;


import example.commands.CommandHandler;
import example.commands.CreatePackingListWithItems;
import example.commands.handlers.CreatePackingListWithItemsHandler;
import example.repository.PackingListRepository;
import example.services.PackingListReadService;
import example.services.WeatherService;

public class CreatePackingListWithItemsHandlerTest {

    private final CommandHandler<CreatePackingListWithItems> commandHandler;
    private final PackingListRepository packingListRepository;
    private final WeatherService weatherService;
    private final PackingListReadService readService;

    public CreatePackingListWithItemsHandlerTest(CommandHandler<CreatePackingListWithItems> commandHandler, PackingListRepository packingListRepository, WeatherService weatherService, PackingListReadService readService) {
        this.commandHandler = commandHandler;
        this.packingListRepository = packingListRepository;
        this.weatherService = weatherService;
        this.readService = readService;
    }
    
    
    
    
    
    
    
}
