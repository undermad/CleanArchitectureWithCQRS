package example.services;

import example.entities.PackingList;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class PackingListRespositoryImplTest implements PackingListRepository {
    @Override
    public CompletableFuture<Boolean> existAsync(PackingListName name) {
        return null;
    }

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
