package ectimel.mappers.read;

import example.dto.PackingItemDto;
import example.mapper.Mapper;
import example.value_objects.PackingItem;
import org.springframework.stereotype.Component;

@Component
public class PackingItemToDto implements Mapper<PackingItem, PackingItemDto> {
    @Override
    public PackingItem mapToA(PackingItemDto packingItemDto) {
        return new PackingItem(packingItemDto.uuid(), packingItemDto.name(), packingItemDto.quantity(), packingItemDto.isPackied());
    }

    @Override
    public PackingItemDto mapToB(PackingItem packingItem) {
        return new PackingItemDto(packingItem.uuid(), packingItem.name(), packingItem.quantity(), packingItem.isPacked());
    }
}
