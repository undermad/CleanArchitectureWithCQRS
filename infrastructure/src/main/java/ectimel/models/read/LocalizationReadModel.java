package ectimel.models.read;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "localization")
@Entity
public record LocalizationReadModel(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        UUID id,

        @Column(name = "city")
        String city,

        @Column(name = "country")
        String country,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "packing_list_id", referencedColumnName = "id")
        PackingListReadModel packingListReadModel

) {
}
