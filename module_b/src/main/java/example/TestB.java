package example;

import example.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TestB {
    
    private final ApplicationEventPublisher eventPublisher;


    public TestB(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    
    public void performMessage(){
        CustomEvent customEvent = new CustomEvent(this, "Message from custom event creator!");
        eventPublisher.publishEvent(customEvent);
    }
    
}
