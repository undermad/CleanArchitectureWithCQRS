package example.configuration;


import example.configuration.registrar.PolicyBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PolicyBeanDefinitionRegistrar.class)
public class PolicyConfiguration {
}
