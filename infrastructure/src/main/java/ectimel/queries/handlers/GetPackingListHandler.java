package ectimel.queries.handlers;

import example.dto.PackingListDto;
import example.queries.GetPackingList;
import example.queries.QueryHandler;
import example.repository.PackingListRepository;

import java.util.concurrent.CompletableFuture;

public class GetPackingListHandler implements QueryHandler<GetPackingList, PackingListDto> {

    private final PackingListRepository repository;

    public GetPackingListHandler(PackingListRepository repository) {
        this.repository = repository;
    }


    @Override
    public CompletableFuture<PackingListDto> handleAsync(GetPackingList query) {
        return CompletableFuture.supplyAsync(() -> {

            
            
            PackingListDto packingListDto = new PackingListDto();
            return packingListDto;
        });
    }
}
