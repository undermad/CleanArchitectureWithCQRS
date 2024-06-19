package example.queries;

import java.util.concurrent.CompletableFuture;

public interface QueryHandler<TQuery extends Query<TResult>, TResult> {
    
    CompletableFuture<TResult> handleAsync(TQuery query);
}
