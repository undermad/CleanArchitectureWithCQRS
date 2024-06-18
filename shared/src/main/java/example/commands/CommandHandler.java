package example.commands;


import java.util.concurrent.CompletableFuture;

public interface CommandHandler<TCommand extends Command> {
    CompletableFuture<Void> handleAsync(TCommand command);
}
