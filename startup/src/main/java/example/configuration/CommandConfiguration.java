package example.configuration;

import example.commands.CommandMediator;
import example.commands.CommandMediatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {
    
    @Bean
    public CommandMediator registerHandlers() {
        CommandMediator mediator = new CommandMediatorImpl();
        

        return mediator;
    }
    
}
