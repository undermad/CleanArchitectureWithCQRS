package example.configuration;

import example.commands.*;
import example.commands.handlers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {
    
    private final CreatePackingListWithItemsHandler createPackingListWithItemsHandler;
    private final AddPackingItemHandler addPackingItemHandler;
    private final RemovePackingItemHandler removePackingItemHandler;
    private final RemovePackingListHandler removePackingListHandler;
    private final PackItemHandler packItemHandler;
    

    public CommandConfiguration(CreatePackingListWithItemsHandler createPackingListWithItemsHandler, AddPackingItemHandler addPackingItemHandler, RemovePackingItemHandler removePackingItemHandler, RemovePackingListHandler removePackingListHandler, PackItemHandler packItemHandler) {
        this.createPackingListWithItemsHandler = createPackingListWithItemsHandler;
        this.addPackingItemHandler = addPackingItemHandler;
        this.removePackingItemHandler = removePackingItemHandler;
        this.removePackingListHandler = removePackingListHandler;
        this.packItemHandler = packItemHandler;
    }


    @Bean
    public CommandDispatcher registerHandlers() {
        CommandDispatcher dispatcher = new CommandDispatcherImpl();
        dispatcher.registerHandlers(CreatePackingListWithItems.class, createPackingListWithItemsHandler);
        dispatcher.registerHandlers(AddPackingItem.class, addPackingItemHandler);
        dispatcher.registerHandlers(RemovePackingItem.class, removePackingItemHandler);
        dispatcher.registerHandlers(RemovePackingList.class, removePackingListHandler);
        dispatcher.registerHandlers(PackItem.class, packItemHandler);
        
        return dispatcher;
    }
    
}
