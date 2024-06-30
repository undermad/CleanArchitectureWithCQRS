package ectimel.repositories.write;

import ectimel.exception.PackingListNotFoundException;
import ectimel.models.read.PackingListEntity;
import example.entities.PackingList;
import example.repository.PackingListRepository;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Async
@Transactional(transactionManager = "writeTransactionManager")
@Repository
public class MySQLPackingListRepository implements PackingListRepository {

    @PersistenceContext(unitName = "puWrite")
    private final EntityManager entityManager;

    public MySQLPackingListRepository(@Qualifier("writeEntityManagerFactory") EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public CompletableFuture<PackingList> getAsync(PackingListId id) {
        var entity = entityManager.find(PackingListEntity.class, id.value());
        if (entity == null) throw new PackingListNotFoundException(id.value());

        return CompletableFuture.completedFuture(entity.toDomain());
    }

    @Override
    public CompletableFuture<Void> addAsync(PackingList packingList) {
        entityManager.persist(PackingListEntity.toEntity(packingList));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> updateAsync(PackingList packingList) {
        entityManager.merge(PackingListEntity.toEntity(packingList));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> deleteAsync(PackingList packingList) {
        var entity = entityManager.find(PackingListEntity.class, packingList.getUuid().value());
        if (entity != null) {
            entityManager.remove(entity);
        }
        return CompletableFuture.completedFuture(null);
    }
}
