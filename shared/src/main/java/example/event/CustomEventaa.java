package example.event;

import lombok.Getter;


@Getter
public class CustomEventaa extends Eventaa {
    
    private String message;
    
    public CustomEventaa(Object source, String message) {
        super(source);
        this.message = message;
    }
    
    
    
    
}
