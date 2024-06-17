package example;

import example.event.CustomEventaa;
import example.policies.LowTemperaturePolicy;
import example.policies.MaleGenderPolicy;
import example.policies.PackingItemPolicy;
import example.policies.Policy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventHandlerService {
    


    @EventListener
    public void handleCustomEvent(CustomEventaa event) {
        System.out.println("Message Created!");
    } 
}
