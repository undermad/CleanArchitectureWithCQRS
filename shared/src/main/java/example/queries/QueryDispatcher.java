package example.queries;

import java.util.concurrent.CompletableFuture;

public interface QueryDispatcher {

    <TQuery extends Query<TResult>, TResult> void registerHandlers(Class<TQuery> queryType, QueryHandler<TQuery, TResult> handler);
    
     <TResult> CompletableFuture<TResult> query(Query<TResult> query); 
}
