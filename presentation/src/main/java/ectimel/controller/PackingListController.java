package ectimel.controller;

import example.commands.CommandDispatcher;
import example.dto.PackingListDto;
import example.queries.GetPackingList;
import example.queries.Query;
import example.queries.QueryDispatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/packing_list")
public class PackingListController {

    private final CommandDispatcher commandDispatcher;
    private final QueryDispatcher queryDispatcher;

    public PackingListController(CommandDispatcher commandDispatcher, QueryDispatcher queryDispatcher) {
        this.commandDispatcher = commandDispatcher;
        this.queryDispatcher = queryDispatcher;
    }


    @GetMapping("/{packingListId}")
    public ResponseEntity<PackingListDto> getPackingList(@PathVariable String packingListId) {
        Query<PackingListDto> query = new GetPackingList(UUID.fromString(packingListId));
        
        return ResponseEntity.ok(queryDispatcher.query(query).join());
    }


}
