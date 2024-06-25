package ectimel.services;

import ectimel.repositories.read.PackingListReadJpaRepository;
import example.services.PackingListReadService;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class MySqlPackingListReadService implements PackingListReadService {
    
    
    private final PackingListReadJpaRepository repository;

    public MySqlPackingListReadService(PackingListReadJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Boolean> existsByNameAsync(String name) {
        return CompletableFuture.supplyAsync(() -> {
            return repository.existsByName(name);
        });
    }
}
