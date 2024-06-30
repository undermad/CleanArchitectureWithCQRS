package ectimel.queries;

import example.dto.PackingListDto;
import example.queries.Query;

import java.util.UUID;

public record GetPackingList(UUID uuid)  implements Query<PackingListDto> {
}
