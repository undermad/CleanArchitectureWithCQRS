package example.queries;

import example.dto.PackingListDto;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchPackingList implements Query<List<PackingListDto>> {
    private String searchPhrase;
}
