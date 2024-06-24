package ectimel.queries.handlers;

import ectimel.exception.PackingListNotFoundException;
import ectimel.mappers.read.PackingListToDtoMapper;
import ectimel.repositories.read.PackingListReadJpaRepository;
import example.dto.PackingListDto;
import example.entities.PackingList;
import example.queries.GetPackingList;
import example.queries.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class GetPackingListHandler implements QueryHandler<GetPackingList, PackingListDto> {

    private final PackingListReadJpaRepository repository;
    private final PackingListToDtoMapper packingListMapper;

    public GetPackingListHandler(PackingListReadJpaRepository repository, PackingListToDtoMapper packingListMapper) {
        this.repository = repository;
        this.packingListMapper = packingListMapper;
    }


    @Override
    public CompletableFuture<PackingListDto> handleAsync(GetPackingList query) {
        return CompletableFuture.supplyAsync(() -> {
            PackingList packingList = repository.findById(query.uuid())
                    .orElseThrow(() -> new PackingListNotFoundException(query.uuid()))
                    .toDomain();
            return packingListMapper.mapToB(packingList);
        });
    }


}
