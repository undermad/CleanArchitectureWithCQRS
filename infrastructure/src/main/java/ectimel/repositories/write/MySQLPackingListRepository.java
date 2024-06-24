package ectimel.repositories.write;

import ectimel.exception.PackingListNotFoundException;
import ectimel.mappers.read.PackingListToDtoMapper;
import ectimel.repositories.read.PackingListReadJpaRepository;
import example.entities.PackingList;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class MySQLPackingListRepository implements PackingListRepository {
    
    private final PackingListWriteJpaRepository repository;

    public MySQLPackingListRepository(PackingListWriteJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public CompletableFuture<PackingList> getAsync(PackingListId id) {
        return CompletableFuture.supplyAsync(() -> repository.findById(id.value())
                .orElseThrow(() -> new PackingListNotFoundException(id.value()))
                .toDomain());
    }

    @Override
    public CompletableFuture<Void> addAsync(PackingList packingList) {
        return CompletableFuture.supplyAsync(() -> {
            return null;
        });
    }

    @Override
    public CompletableFuture<Void> updateAsync(PackingList packingList) {
        return null;
    }

    @Override
    public CompletableFuture<Void> deleteAsync(PackingList packingList) {
        return null;
    }
}
