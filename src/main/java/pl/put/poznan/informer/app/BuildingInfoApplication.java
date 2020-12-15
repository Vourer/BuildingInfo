package pl.put.poznan.informer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Główna klasa projektu BuildingInfo, odpowiedzialna za uruchamianie programu
 * @version 1.0.1
 * @author Delta
 */

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.informer.rest"})
public class BuildingInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
