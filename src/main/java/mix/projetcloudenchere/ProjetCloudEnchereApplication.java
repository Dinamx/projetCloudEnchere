package mix.projetcloudenchere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "mix.projetcloudenchere.controllerjsp")
public class ProjetCloudEnchereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetCloudEnchereApplication.class, args);
    }

}
