package ectimel.models.read;

import example.entities.PackingList;
import example.value_objects.PackingItem;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "packing_list")
@Entity
public class PackingListEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "packingListEntity", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private LocalizationEntity localizationEntity;

    @OneToMany(mappedBy = "packingListEntity", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<PackingItemEntity> items;


    public PackingList toDomain() {
        PackingList packingList = new PackingList(
                new PackingListId(this.id),
                new PackingListName(this.getName()),
                localizationEntity.toDomain());

        List<PackingItem> packingItemList = this.items.stream()
                .map(PackingItemEntity::toDomain)
                .toList();

        packingList.addItems(packingItemList);

        return packingList;
    }

    public static PackingListEntity toEntity(PackingList packingList) {

        var packingListEntity = new PackingListEntity();
        packingListEntity.setLocalizationEntity(new LocalizationEntity(
                packingList.getLocalization().uuid(),
                packingList.getLocalization().city(),
                packingList.getLocalization().country(),
                packingListEntity));
        
        packingListEntity.setItems(packingList.getItems().stream()
                .map(packingItem -> PackingItemEntity.create(packingItem, packingListEntity))
                .toList());

        packingListEntity.setId(packingList.getUuid().value());
        packingListEntity.setName(packingList.getName().value());
        
        return packingListEntity;
    }


}
