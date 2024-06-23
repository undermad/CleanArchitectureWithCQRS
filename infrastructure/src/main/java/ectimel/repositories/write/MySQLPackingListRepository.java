package ectimel.repositories.write;

import ectimel.repositories.read.PackingListJpaRepository;
import example.entities.PackingList;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class MySQLPackingListRepository implements PackingListRepository {

    @Override
    public CompletableFuture<PackingList> getAsync(PackingListId id) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addAsync(PackingList packingList) {
        return null;
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
