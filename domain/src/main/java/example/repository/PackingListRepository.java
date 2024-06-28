package example.repository;

import example.entities.PackingList;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;

import java.util.concurrent.CompletableFuture;

public interface PackingListRepository {
    CompletableFuture<Boolean> existsByNameAsync(PackingListName packingListName);
    CompletableFuture<PackingList> getAsync(PackingListId id);

    CompletableFuture<Void> addAsync(PackingList packingList);

    CompletableFuture<Void> updateAsync(PackingList packingList);

    CompletableFuture<Void> deleteAsync(PackingList packingList);
}
