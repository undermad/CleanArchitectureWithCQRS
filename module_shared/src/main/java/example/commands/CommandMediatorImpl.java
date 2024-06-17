package example.commands;

import example.exceptions.HandlerNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CommandMediatorImpl implements CommandMediator {
    
    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> handlers = new HashMap<>();
    
    @Override
    public <TCommand extends Command> void registerHandlers(Class<TCommand> commandType, CommandHandler<TCommand> handler) {
        handlers.put(commandType, handler);
    }

    @Override
    public <TCommand extends Command> CompletableFuture<Void> send(TCommand command) {
        CommandHandler<TCommand> handler = (CommandHandler<TCommand>) handlers.get(command.getClass());
        if(handler == null) {
            return CompletableFuture.failedFuture(new HandlerNotFoundException(command));
        }
        
        return handler.handleAsync(command);
    }
}
