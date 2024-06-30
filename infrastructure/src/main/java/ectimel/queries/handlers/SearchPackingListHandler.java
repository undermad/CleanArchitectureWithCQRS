package ectimel.queries.handlers;

import ectimel.mappers.read.PackingListToDtoMapper;
import ectimel.models.read.PackingListEntity;
import example.dto.PackingListDto;
import example.queries.QueryHandler;
import ectimel.queries.SearchPackingList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class SearchPackingListHandler implements QueryHandler<SearchPackingList, List<PackingListDto>> {

    private final PackingListToDtoMapper packingListToDtoMapper;

    @Qualifier("readEntityManager")
    private final EntityManager entityManager;

    public SearchPackingListHandler(PackingListToDtoMapper packingListToDtoMapper,@Qualifier("readEntityManagerFactory")  EntityManager entityManager) {
        this.packingListToDtoMapper = packingListToDtoMapper;
        this.entityManager = entityManager;
    }

    @Async
    @Transactional(transactionManager = "readTransactionManager")
    @Override
    public CompletableFuture<List<PackingListDto>> handleAsync(SearchPackingList query) {
        
        
        TypedQuery<PackingListEntity> typedQuery = entityManager.createQuery(
                "SELECT p FROM PackingListEntity p WHERE p.name LIKE :name", PackingListEntity.class);
        typedQuery.setParameter("name", "%" + query.queryString() + "%");

        return CompletableFuture.completedFuture(typedQuery.getResultList()
                .stream()
                .map(PackingListEntity::toDomain)
                .map(packingListToDtoMapper::mapToB)
                .toList());
    }
}
