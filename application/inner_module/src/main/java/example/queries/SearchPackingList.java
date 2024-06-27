package example.queries;

import example.dto.PackingListDto;
import lombok.Getter;

import java.util.List;

public record SearchPackingList(String queryString) implements Query<List<PackingListDto>> {
}
