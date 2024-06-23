package ectimel.models.read;

import example.value_objects.PackingItem;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "packing_item")
@Entity
public record PackingItemEntity(
        @Id
        UUID id,

        @Column(name = "name")
        String name,

        @Column(name = "quantity", nullable = false)
        Integer quantity,

        @Column(name = "is_packed")
        Boolean isPacked,

        @ManyToOne
        @JoinColumn(name = "packing_list_id", referencedColumnName = "id")
        PackingListEntity packingListEntity

) {


    public PackingItem toDomain() {
        return new PackingItem(this.name, this.quantity, this.isPacked);
    }

}
