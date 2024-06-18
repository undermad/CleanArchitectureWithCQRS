package example.exceptions;

import example.commands.Command;

public class HandlerNotFoundException extends PackItException {
    public HandlerNotFoundException(Command command) {
        super("Command handler not found for: " + command.getClass().getName());
    }
}
