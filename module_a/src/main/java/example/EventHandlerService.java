package example;

import org.springframework.context.event.EventListener;

public class EventHandlerService {
    
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("USER CREATED");
    } 
}
