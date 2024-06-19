package example.queries;

import java.time.temporal.TemporalQuery;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class InMemoryQueryDispatcher implements QueryDispatcher {
    
    
    @Override
    public <TQuery extends Query<TResult>, TResult> void registerHandlers(Class<TQuery> queryType, QueryHandler<TQuery, TResult> handler) {
        
    }

    @Override
    public <TResult> CompletableFuture<TResult> query(Query<TResult> query) {
        
        return null;
    }
}
