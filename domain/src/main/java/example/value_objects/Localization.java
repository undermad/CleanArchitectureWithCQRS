package example.value_objects;

import java.util.UUID;

public record Localization(UUID uuid,String city, String country) {
    
    public Localization (String city, String country){
        this(UUID.randomUUID(), city, country);
    }
}
