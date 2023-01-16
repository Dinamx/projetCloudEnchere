package mix.projetcloudenchere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "mix.projetcloudenchere.controllerjsp")
@ComponentScan(basePackages = "mix.projetcloudenchere.controllerWeb")
public class ProjetCloudEnchereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetCloudEnchereApplication.class, args);
    }

}
