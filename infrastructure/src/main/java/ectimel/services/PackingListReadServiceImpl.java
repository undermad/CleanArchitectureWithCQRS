package ectimel.services;

import example.services.PackingListReadService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class PackingListReadServiceImpl implements PackingListReadService {
    
    private final EntityManager entityManager;

    public PackingListReadServiceImpl(@Qualifier("readEntityManagerFactory") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CompletableFuture<Boolean> existByNameAsync(String name) {
        Query query = entityManager.createQuery("SELECT CASE WHEN COUNT(pl) > 0 THEN TRUE ELSE FALSE END FROM PackingListEntity pl WHERE pl.name = :name");
        query.setParameter("name", name);

        return CompletableFuture.completedFuture((Boolean) query.getSingleResult());
    }
}
