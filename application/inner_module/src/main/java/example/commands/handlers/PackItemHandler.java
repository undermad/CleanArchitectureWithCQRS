package example.commands.handlers;

import example.commands.CommandHandler;
import example.commands.PackItem;
import example.exceptions.PackingListDoesntExistException;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class PackItemHandler implements CommandHandler<PackItem> {
    
    private final PackingListRepository repository;

    public PackItemHandler(PackingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Void> handleAsync(PackItem command) {
        return CompletableFuture.runAsync(() -> {
            var packingList = repository.getAsync(new PackingListId(command.packingListId())).join();
            if(packingList == null) throw new PackingListDoesntExistException(command.packingListId());
            
            packingList.packItem(command.packingItemName());
            repository.updateAsync(packingList);
        });
    }
}
