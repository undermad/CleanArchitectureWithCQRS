package ectimel.controller;

import example.commands.*;
import example.dto.PackingListDto;
import example.queries.GetPackingList;
import example.queries.Query;
import example.queries.QueryDispatcher;
import example.queries.SearchPackingList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    
    @GetMapping()
    public ResponseEntity<List<PackingListDto>> getPackingListByQuery(@RequestParam(required = true) String queryString){
        Query<List<PackingListDto>> query = new SearchPackingList(queryString);
        return ResponseEntity.ok(queryDispatcher.query(query).join());
    }

    @PostMapping()
    public ResponseEntity<Void> createPackingList(@RequestBody CreatePackingListWithItems command){
        return ResponseEntity.ok(commandDispatcher.send(command).join());
    }

    @DeleteMapping
    public ResponseEntity<Void> removePackingList(@RequestBody RemovePackingList command){
        return ResponseEntity.ok(commandDispatcher.send(command).join());
    }
    
    @PutMapping("/items")
    public ResponseEntity<Void> addItemToPackingList(@RequestBody AddPackingItem command){
        return ResponseEntity.ok(commandDispatcher.send(command).join());
    }

    @PutMapping("/items/pack")
    public ResponseEntity<Void> packItem(@RequestBody PackItem command){
        return ResponseEntity.ok(commandDispatcher.send(command).join());
    }
    
    @DeleteMapping("/items")
    public ResponseEntity<Void> removePackingItem(@RequestBody RemovePackingItem command) {
        return ResponseEntity.ok(commandDispatcher.send(command).join());
    }
    
}
