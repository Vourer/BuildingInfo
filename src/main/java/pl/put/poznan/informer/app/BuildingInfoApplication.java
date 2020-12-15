package pl.put.poznan.informer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.informer.rest"})
public class BuildingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
