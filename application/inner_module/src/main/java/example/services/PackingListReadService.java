package example.services;


import java.util.concurrent.CompletableFuture;

public interface PackingListReadService {
    
    CompletableFuture<Boolean> existByNameAsync(String name);
}
