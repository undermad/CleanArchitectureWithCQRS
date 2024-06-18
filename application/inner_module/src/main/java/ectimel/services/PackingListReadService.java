package ectimel.services;

import java.util.concurrent.CompletableFuture;

public interface PackingListReadService {

    CompletableFuture<Boolean> existsByNameAsync(String name);
    
}
