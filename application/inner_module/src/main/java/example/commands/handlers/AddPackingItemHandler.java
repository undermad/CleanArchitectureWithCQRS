package example.commands.handlers;

import example.commands.AddPackingItem;
import example.commands.CommandHandler;
import example.exceptions.PackingListDoesntExistException;
import example.repository.PackingListRepository;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AddPackingItemHandler implements CommandHandler<AddPackingItem> {

    private final PackingListRepository repository;

    public AddPackingItemHandler(PackingListRepository repository) {
        this.repository = repository;
    }


    @Override
    public CompletableFuture<Void> handleAsync(AddPackingItem command) {
        return CompletableFuture.runAsync(() -> {
            var packingList = repository.getAsync(new PackingListId(command.packingListId())).join();
            
            if(packingList == null) throw new PackingListDoesntExistException(command.packingListId());
            
            var item = new PackingItem(command.name(), command.quantity(), false);
            packingList.addItem(item);
            
            repository.updateAsync(packingList).join();
        });
    }
}
