package example.commands.handlers;

import example.commands.CommandHandler;
import example.commands.RemovePackingItem;
import example.exceptions.PackingListDoesntExistException;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class RemovePackingItemHandler implements CommandHandler<RemovePackingItem> {

    private final PackingListRepository repository;

    public RemovePackingItemHandler(PackingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Void> handleAsync(RemovePackingItem command) {
        return CompletableFuture.runAsync(() -> {

            var packingList = repository.getAsync(new PackingListId(command.packingListId())).join();
            if (packingList == null) throw new PackingListDoesntExistException(command.packingListId());
            
            packingList.removeItem(command.packingItemName());
            repository.updateAsync(packingList);
        });
    }
}
