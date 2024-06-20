package example.queries;

import example.exceptions.HandlerNotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class InMemoryQueryDispatcher implements QueryDispatcher, ApplicationContextAware {

    public ApplicationContext applicationContext;


    @Override
    public <TQuery extends Query<TResult>, TResult> void registerHandlers(Class<TQuery> queryType, QueryHandler<TQuery, TResult> handler) {

    }

    @Override
    public <TResult> CompletableFuture<TResult> query(Query<TResult> query) {

        String queryName = query.getClass().getSimpleName();
        var type = query.getClass().getGenericSuperclass();
//        if (type instanceof ParameterizedType) {
//            ParameterizedType parameterizedType = (ParameterizedType) type;
//            Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
//            Class<?> actualTypeClass = (Class<?>) actualTypeArgument;
//        }

        Object handlerBean = applicationContext.getBean(queryName + "Handler");
        if (handlerBean instanceof QueryHandler) {
            QueryHandler<Query<TResult>, TResult> handler = (QueryHandler<Query<TResult>, TResult>) handlerBean;
            return handler.handleAsync(query);
        } 
        throw new IllegalArgumentException("Wrong handler");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
