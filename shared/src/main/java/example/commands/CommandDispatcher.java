package example.commands;

import java.util.concurrent.CompletableFuture;

public interface CommandDispatcher {
    <TCommand extends Command> void registerHandlers(Class<TCommand> commandType, CommandHandler<TCommand> handler);

    <TCommand extends Command> CompletableFuture<Void> send(TCommand command);
}
