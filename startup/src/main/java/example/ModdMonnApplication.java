package example;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"ectimel", "example"})
@EnableJpaRepositories(basePackages = "ectimel.repositories")
@EntityScan(basePackages = {"ectimel"})
public class ModdMonnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModdMonnApplication.class, args);
    }
}
