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
    private final DeletePackingListHandler deletePackingListHandler;
    private final PackItemHandler packItemHandler;
    

    public CommandConfiguration(CreatePackingListWithItemsHandler createPackingListWithItemsHandler, AddPackingItemHandler addPackingItemHandler, RemovePackingItemHandler removePackingItemHandler, DeletePackingListHandler deletePackingListHandler, PackItemHandler packItemHandler) {
        this.createPackingListWithItemsHandler = createPackingListWithItemsHandler;
        this.addPackingItemHandler = addPackingItemHandler;
        this.removePackingItemHandler = removePackingItemHandler;
        this.deletePackingListHandler = deletePackingListHandler;
        this.packItemHandler = packItemHandler;
    }


    @Bean
    public CommandDispatcher registerHandlers() {
        CommandDispatcher dispatcher = new CommandDispatcherImpl();
        dispatcher.registerHandlers(CreatePackingListWithItems.class, createPackingListWithItemsHandler);
        dispatcher.registerHandlers(AddPackingItem.class, addPackingItemHandler);
        dispatcher.registerHandlers(RemovePackingItem.class, removePackingItemHandler);
        dispatcher.registerHandlers(DeletePackingList.class, deletePackingListHandler);
        dispatcher.registerHandlers(PackItem.class, packItemHandler);
        
        return dispatcher;
    }
    
}
