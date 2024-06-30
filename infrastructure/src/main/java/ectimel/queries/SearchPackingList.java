package ectimel.queries;

import example.dto.PackingListDto;
import example.queries.Query;
import lombok.Getter;

import java.util.List;

public record SearchPackingList(String queryString) implements Query<List<PackingListDto>> {
}
