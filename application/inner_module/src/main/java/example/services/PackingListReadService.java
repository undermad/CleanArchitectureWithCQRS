package example.services;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PackingListReadService {

    CompletableFuture<Boolean> existsByNameAsync(String name);
    CompletableFuture<Boolean> existByUUID(UUID uuid);
    
}
