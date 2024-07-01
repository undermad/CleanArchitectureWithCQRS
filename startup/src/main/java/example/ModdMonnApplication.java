package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"ectimel", "example"})
@EntityScan(basePackages = {"ectimel.models.read", "example.entities"})
public class ModdMonnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModdMonnApplication.class, args);
    }
}
