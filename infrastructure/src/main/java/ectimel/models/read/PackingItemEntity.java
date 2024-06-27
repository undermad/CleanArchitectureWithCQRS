package ectimel.models.read;

import example.value_objects.PackingItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packing_item")
@Entity
public class PackingItemEntity {

    @Id
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "quantity", nullable = false)
    Integer quantity;

    @Column(name = "is_packed")
    Boolean isPacked;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "packing_list_id", referencedColumnName = "id")
    PackingListEntity packingListEntity;


    public PackingItem toDomain() {
        return new PackingItem(this.id, this.name, this.quantity, this.isPacked);
    }

    public static PackingItemEntity create(PackingItem packingItem, PackingListEntity packingListEntity) {
        return new PackingItemEntity(packingItem.uuid(), packingItem.name(), packingItem.quantity(), packingItem.isPacked(), packingListEntity);
    }

}
