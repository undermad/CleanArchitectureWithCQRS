package example.policies;

import example.value_objects.PackingItem;

import java.util.LinkedList;
import java.util.List;

public final class HighTemperaturePolicy implements PackingItemPolicy {
    
    @Override
    public Boolean IsApplicable(PolicyData data) {
        return data.temperature().value() > 20D;
    }

    @Override
    public List<PackingItem> generateItems(PolicyData data) {
        List<PackingItem> items = new LinkedList<>();
        items.add(new PackingItem("Hat", 1, false));
        items.add(new PackingItem("Suncream", 1, false));
        items.add(new PackingItem("Sunglasses", 1, false));
        return items;
    }
}
