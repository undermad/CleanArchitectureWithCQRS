package example.event;

import org.springframework.context.ApplicationEvent;

import java.util.Date;
import java.util.UUID;

public abstract class Eventaa extends ApplicationEvent {
    
    public final UUID id;
    public final Date createDate;
    
    
    public Eventaa(Object source) {
        super(source);
        
        id = UUID.randomUUID();
        createDate = new Date();
        
    }
}
