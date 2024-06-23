package example.queries;

import example.dto.PackingListDto;

import java.util.UUID;

public record GetPackingList(UUID uuid)  implements Query<PackingListDto> {
}
