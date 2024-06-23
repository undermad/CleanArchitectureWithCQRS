package example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PackingListDto {
    
    private UUID uuid;
    private String name;
    private LocalizationDto localizationDto;
    private List<PackingItemDto> items;
}
