package example.configuration;

import example.factories.PackingListFactory;
import example.factories.PackingListFactoryImpl;
import example.policies.PackingItemPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FactoryConfiguration {
    
    @Bean
    public PackingListFactory packingListFactory(List<PackingItemPolicy> policies) {
        return new PackingListFactoryImpl(policies);
    }

}
