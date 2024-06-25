package ectimel.models.read;

import example.value_objects.Localization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "localization")
@Entity
public class LocalizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "city")
    String city;

    @Column(name = "country")
    String country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packing_list_id", referencedColumnName = "id")
    PackingListEntity packingListEntity;


    public Localization toDomain() {
        return new Localization(this.id, this.city, this.country);
    }
}
