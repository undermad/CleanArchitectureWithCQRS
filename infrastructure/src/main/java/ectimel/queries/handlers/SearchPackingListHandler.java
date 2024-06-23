package ectimel.queries.handlers;

import ectimel.mappers.read.PackingListToDtoMapper;
import ectimel.models.read.PackingListEntity;
import ectimel.repositories.read.PackingListJpaRepository;
import example.dto.PackingListDto;
import example.queries.QueryHandler;
import example.queries.SearchPackingList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class SearchPackingListHandler implements QueryHandler<SearchPackingList, List<PackingListDto>> {

    private final PackingListJpaRepository repository;
    private final PackingListToDtoMapper packingListToDtoMapper;

    public SearchPackingListHandler(PackingListJpaRepository repository, PackingListToDtoMapper packingListToDtoMapper) {
        this.repository = repository;
        this.packingListToDtoMapper = packingListToDtoMapper;
    }

    @Override
    public CompletableFuture<List<PackingListDto>> handleAsync(SearchPackingList query) {
        return CompletableFuture.supplyAsync(() -> {
            List<PackingListEntity> packingListEntities = repository.findAllByQuery(query.getSearchPhrase());
            return packingListEntities.stream()
                    .map(PackingListEntity::toDomain)
                    .map(packingListToDtoMapper::mapToB)
                    .toList();
        });
    }
}
