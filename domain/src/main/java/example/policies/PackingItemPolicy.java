package example.policies;

import example.value_objects.PackingItem;

import java.util.List;

public sealed interface PackingItemPolicy permits FemaleGenderPolicy, MaleGenderPolicy, HighTemperaturePolicy, LowTemperaturePolicy, BasicPolicy {
    Boolean IsApplicable(PolicyData data);
    List<PackingItem> generateItems(PolicyData data);
}
