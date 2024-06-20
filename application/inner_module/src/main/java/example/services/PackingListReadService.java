package example.services;

import example.dto.PackingListDto;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PackingListReadService {

    CompletableFuture<Boolean> existsByNameAsync(String name);
    
}
