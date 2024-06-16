package example.policies;

import example.constants.Gender;
import example.value_objects.PackingItem;

import java.util.LinkedList;
import java.util.List;

public final class MaleGenderPolicy implements PackingItemPolicy {
    
    @Override
    public Boolean IsApplicable(PolicyData data) {
        return data.gender() == Gender.MALE;
    }

    @Override
    public List<PackingItem> generateItems(PolicyData data) {
        List<PackingItem> items = new LinkedList<>();
        items.add(new PackingItem("Laptop", 1, false));
        items.add(new PackingItem("Book", 1, false));
        return items;
    }
}
