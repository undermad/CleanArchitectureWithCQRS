package ectimel.queries.handlers;

import ectimel.exception.PackingListNotFoundException;
import ectimel.mappers.read.PackingListToDtoMapper;
import ectimel.models.read.PackingListEntity;
import example.dto.PackingListDto;
import ectimel.queries.GetPackingList;
import example.queries.QueryHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Component
public class GetPackingListHandler implements QueryHandler<GetPackingList, PackingListDto> {

    private final PackingListToDtoMapper packingListToDtoMapper;

    @PersistenceContext(unitName = "puRead")
    private final EntityManager entityManager;

    public GetPackingListHandler(PackingListToDtoMapper packingListToDtoMapper,
                                 @Qualifier("readEntityManagerFactory") 
                                 EntityManager entityManager) {
        this.packingListToDtoMapper = packingListToDtoMapper;
        this.entityManager = entityManager;
    }


    @Async
    @Transactional(transactionManager = "readTransactionManager")
    @Override
    public CompletableFuture<PackingListDto> handleAsync(GetPackingList query) {
            var entity = entityManager.find(PackingListEntity.class, query.uuid());
            if(entity == null) throw new PackingListNotFoundException(query.uuid());
            
            return CompletableFuture.completedFuture(packingListToDtoMapper.mapToB(entity.toDomain()));
    }


}
