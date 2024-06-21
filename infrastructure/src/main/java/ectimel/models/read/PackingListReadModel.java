package ectimel.models.read;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "packing_list")
@Entity(name = "packing_list")
public class PackingListReadModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "name")
    private String name;
    
    @OneToOne(mappedBy = "packingListReadModel", fetch = FetchType.EAGER)
    private LocalizationReadModel localizationReadModel;
    
    @OneToMany(mappedBy = "packingListReadModel")
    private List<PackingItemReadModel> items;
}
