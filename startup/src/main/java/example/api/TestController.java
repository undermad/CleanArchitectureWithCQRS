package example.api;

import example.constants.Gender;
import example.policies.PackingItemPolicy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    

    private List<PackingItemPolicy> policies;

    public TestController(List<PackingItemPolicy> policies) {
        this.policies = policies;
    }

    @GetMapping("/policy")
    public ResponseEntity<List<String>> getPolicies() {
        return ResponseEntity.ok(policies.stream().map(packingItemPolicy -> packingItemPolicy.getClass().getName()).toList());
    }


}
