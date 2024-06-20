package example.queries;

import example.dto.PackingListDto;

import java.util.UUID;

public class GetPackingList  implements Query<PackingListDto> {
    private UUID uuid;
}
