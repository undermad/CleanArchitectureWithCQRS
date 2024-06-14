package example;

import example.event.CustomEventaa;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandlerService {
    
    @EventListener
    public void handleCustomEvent(CustomEventaa event) {
        System.out.println("Message Created!");
    } 
}
