package example.queries.handlers;

import example.dto.PackingListDto;
import example.queries.QueryHandler;
import example.queries.SearchPackingList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class SearchPackingListHandler implements QueryHandler<SearchPackingList, List<PackingListDto>> {


    @Override
    public CompletableFuture<List<PackingListDto>> handleAsync(SearchPackingList query) {
        return null;
    }
}
