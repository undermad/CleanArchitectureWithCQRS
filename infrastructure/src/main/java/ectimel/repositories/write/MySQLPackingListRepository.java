package ectimel.repositories.write;

import ectimel.exception.PackingListNotFoundException;
import ectimel.models.read.PackingListEntity;
import example.entities.PackingList;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import jakarta.persistence.EntityManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Async
@Transactional
@Repository
public class MySQLPackingListRepository implements PackingListRepository {

    private final PackingListWriteJpaRepository repository;

    private final EntityManager entityManager;

    public MySQLPackingListRepository(PackingListWriteJpaRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }


    @Override
    public CompletableFuture<PackingList> getAsync(PackingListId id) {
        var packingList = repository.findById(id.value())
                .orElseThrow(() -> new PackingListNotFoundException(id.value()))
                .toDomain();

        return CompletableFuture.completedFuture(packingList);
    }

    @Override
    public CompletableFuture<Void> addAsync(PackingList packingList) {
        entityManager.persist(PackingListEntity.toEntity(packingList));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> updateAsync(PackingList packingList) {
        repository.save(PackingListEntity.toEntity(packingList));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> deleteAsync(PackingList packingList) {
        entityManager.remove(PackingListEntity.toEntity(packingList));
        return CompletableFuture.completedFuture(null);
    }
}
