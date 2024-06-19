package example.commands.handlers;

import example.commands.CommandHandler;
import example.commands.DeletePackingList;
import example.exceptions.PackingListDoesntExistException;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class DeletePackingListHandler implements CommandHandler<DeletePackingList> {

    private final PackingListRepository repository;

    public DeletePackingListHandler(PackingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Void> handleAsync(DeletePackingList command) {
        return CompletableFuture.runAsync(() -> {
            var packingList = repository.getAsync(new PackingListId(command.packingListId())).join();

            if (packingList == null) throw new PackingListDoesntExistException(command.packingListId());
            
            repository.deleteAsync(packingList);
        });
    }
}
