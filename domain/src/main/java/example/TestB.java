package example;

import example.event.CustomEventaa;
import example.value_objects.PackingListName;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TestB {
    
    private final ApplicationEventPublisher eventPublisher;


    public TestB(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    
    public void performMessage(){
        CustomEventaa customEvent = new CustomEventaa(this, "Message from custom event creator!");
        eventPublisher.publishEvent(customEvent);
    }

    public static void main(String[] args) {
        PackingListName packingListName = new PackingListName("Abc");
        System.out.println(packingListName.toString());
    }
}
