package ectimel.models;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PackingListEntity {
    
    private UUID uuid;
    private String name;
    private LocalizationEntity localizationEntity;
    private List<PackingItemEntity> items;
}
