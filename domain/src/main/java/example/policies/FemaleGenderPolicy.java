package example.policies;

import example.constants.Gender;
import example.value_objects.PackingItem;

import java.util.LinkedList;
import java.util.List;

@Policy
public final class FemaleGenderPolicy implements PackingItemPolicy {
    @Override
    public Boolean IsApplicable(PolicyData data) {
        return data.gender() == Gender.FEMALE;
    }

    @Override
    public List<PackingItem> generateItems(PolicyData data) {
        List<PackingItem> items = new LinkedList<>();
        items.add(new PackingItem("Lipstick", 1, false));
        return items;
    }
}
