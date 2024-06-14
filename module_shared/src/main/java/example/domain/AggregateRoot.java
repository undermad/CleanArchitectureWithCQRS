package example.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AggregateRoot<T> {
    private T id;
    private int version;

    private boolean versionIncremented;

    private final List<DomainEvent> events = new ArrayList<>();
    private Iterable<DomainEvent> eventIterable = events;

    protected void addEvent(DomainEvent event) {
        if (events.isEmpty() && !versionIncremented) {
            version++;
            versionIncremented = true;
            
            events.add(event);
        }
    }

    public void clearEvents() {
        events.clear();
    }

    protected void incrementVersion() {
        if (versionIncremented) return;

        version++;
        versionIncremented = true;
    }
}
