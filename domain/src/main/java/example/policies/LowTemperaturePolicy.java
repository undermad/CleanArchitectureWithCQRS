package example.policies;

import example.value_objects.PackingItem;

import java.util.LinkedList;
import java.util.List;

public final class LowTemperaturePolicy implements PackingItemPolicy {
    
    @Override
    public Boolean IsApplicable(PolicyData data) {
        return data.temperature().value() < 10D;
    }

    @Override
    public List<PackingItem> generateItems(PolicyData data) {
        List<PackingItem> items = new LinkedList<>();
        items.add(new PackingItem("Scarf", 1, false));
        items.add(new PackingItem("Jacket", 1, false));
        items.add(new PackingItem("Gloves", 1, false));
        return items;
    }
}
