package example.policies;

import example.value_objects.PackingItem;

import java.util.LinkedList;
import java.util.List;

@Policy
public final class BasicPolicy implements PackingItemPolicy {
    
    private final short MAXIMUM_NUMBER_OF_CLOTHES = 7; 
    
    
    @Override
    public Boolean IsApplicable(PolicyData data) {
        return true;
    }

    @Override
    public List<PackingItem> generateItems(PolicyData data) {
        List<PackingItem> items = new LinkedList<>();
        items.add(new PackingItem("Pants", Math.min(data.days().value(), MAXIMUM_NUMBER_OF_CLOTHES), false));
        items.add(new PackingItem("Socks", Math.min(data.days().value(), MAXIMUM_NUMBER_OF_CLOTHES), false));
        items.add(new PackingItem("T-Shirt", Math.min(data.days().value(), MAXIMUM_NUMBER_OF_CLOTHES), false));
        items.add(new PackingItem("Trousers", data.days().value() < 7 ? 2 : 3, false));
        items.add(new PackingItem("Shampoo", 1, false));
        items.add(new PackingItem("Toothbrush", 1, false));
        items.add(new PackingItem("Toothpaste", 1, false));
        items.add(new PackingItem("Towel", 1, false));
        items.add(new PackingItem("Bag-pack", 1, false));
        items.add(new PackingItem("Passport", 1, false));
        items.add(new PackingItem("Phone Charger", 1, false));
        
        return items;
    }
}
