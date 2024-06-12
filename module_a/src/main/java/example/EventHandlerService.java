package example;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandlerService {
    
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("Message Created!");
    } 
}
