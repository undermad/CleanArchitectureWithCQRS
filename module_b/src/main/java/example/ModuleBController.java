package example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ModuleBController {
    
    private final TestB testB;

    public ModuleBController(TestB testB) {
        this.testB = testB;
    }
    
    
    @GetMapping("/message")
    public ResponseEntity<String> getEventMessage() {
        testB.performMessage();
        return ResponseEntity.ok("Message created");
    }
}
