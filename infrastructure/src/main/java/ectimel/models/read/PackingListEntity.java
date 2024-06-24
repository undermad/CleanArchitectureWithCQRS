package ectimel.models.read;

import example.entities.PackingList;
import example.value_objects.Localization;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "packing_list")
@Entity
public class PackingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "packingListEntity", fetch = FetchType.EAGER)
    private LocalizationEntity localizationEntity;

    @OneToMany(mappedBy = "packingListEntity", fetch = FetchType.EAGER)
    private List<PackingItemEntity> items;


    public PackingList toDomain() {
        PackingList packingList = new PackingList(
                new PackingListId(this.id),
                new PackingListName(this.getName()),
                new Localization(
                        this.localizationEntity.city(),
                        this.localizationEntity.country()));

        List<PackingItem> packingItemList = this.items.stream()
                .map(PackingItemEntity::toDomain)
                .toList();
        
        packingList.addItems(packingItemList);
        
        return packingList;
    }
    

}
