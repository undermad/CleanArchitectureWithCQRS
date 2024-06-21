package example.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PackingListReadServiceImplTest implements PackingListReadService {
    @Override
    public CompletableFuture<Boolean> existsByNameAsync(String name) {
        return null;
    }
}
