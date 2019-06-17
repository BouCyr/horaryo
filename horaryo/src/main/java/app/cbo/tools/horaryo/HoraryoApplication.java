package app.cbo.tools.horaryo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HoraryoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoraryoApplication.class, args);
    }

}
