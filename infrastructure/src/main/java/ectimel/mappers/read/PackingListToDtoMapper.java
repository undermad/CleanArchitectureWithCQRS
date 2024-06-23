package ectimel.mappers.read;

import example.dto.LocalizationDto;
import example.dto.PackingListDto;
import example.entities.PackingList;
import example.mapper.Mapper;
import example.value_objects.Localization;
import example.value_objects.PackingListId;
import example.value_objects.PackingListName;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PackingListToDtoMapper implements Mapper<PackingList, PackingListDto> {


    private final PackingItemToDto packingItemToDto;

    public PackingListToDtoMapper(PackingItemToDto packingItemToDto) {
        this.packingItemToDto = packingItemToDto;
    }


    @Override
    public PackingList mapToA(PackingListDto packingListDto) {
        return new PackingList(
                new PackingListId(packingListDto.getUuid()),
                new PackingListName(packingListDto.getName()),
                new Localization(packingListDto.getLocalizationDto().city(), packingListDto.getLocalizationDto().country())
        );
    }

    @Override
    public PackingListDto mapToB(PackingList packingList) {
        return new PackingListDto(
                packingList.getUuid().value(),
                packingList.getName().value(),
                new LocalizationDto(
                        packingList.getLocalization().city(),
                        packingList.getLocalization().country()),
                packingList.getItems().stream()
                        .map(packingItemToDto::mapToB)
                        .collect(Collectors.toList()));
    }
}
