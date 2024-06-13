package example.event;

import lombok.Getter;


@Getter
public class CustomEvent extends Event {
    
    private String message;
    
    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    
    
    
}
