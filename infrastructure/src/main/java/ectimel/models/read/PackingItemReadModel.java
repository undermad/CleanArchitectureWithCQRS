package ectimel.models.read;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "packing_item")
@Entity
public record PackingItemReadModel(
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
        PackingListReadModel packingListReadModel

) {

}
