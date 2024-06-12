package example;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    
    
    private TestA testA;


    public TestService(TestA testA) {
        this.testA = testA;
    }
}
