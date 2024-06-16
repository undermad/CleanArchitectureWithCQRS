package example.factories;

import example.constants.Gender;
import example.entities.PackingList;
import example.policies.PackingItemPolicy;
import example.policies.PolicyData;
import example.value_objects.*;

import java.util.List;

public class PackingListFactoryImpl implements PackingListFactory {

    private final List<PackingItemPolicy> policies;

    public PackingListFactoryImpl(List<PackingItemPolicy> policies) {
        this.policies = policies;
    }

    @Override
    public PackingList create(PackingListId packingListId, PackingListName packingListName, Localization localization) {
        return new PackingList(packingListId, packingListName, localization);
    }

    @Override
    public PackingList createWithDefaultItems(PackingListId packingListId, PackingListName packingListName, Localization localization, TravelDays travelDays, Gender gender, Temperature temperature) {

        var data = new PolicyData(travelDays, gender, temperature, localization);
        var applicablePolicies = policies.stream()
                .filter(policy -> policy.IsApplicable(data))
                .map(policy -> policy.generateItems(data))
                .toList();
        
        var items = applicablePolicies.stream().flatMap(List::stream).toList();
        var packingList = create(packingListId, packingListName, localization);
        
        packingList.addItems(items);
        
        return packingList;
    }
}
