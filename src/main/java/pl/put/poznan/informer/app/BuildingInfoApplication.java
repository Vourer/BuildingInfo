package pl.put.poznan.informer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Glowna klasa projektu BuildingInfo, odpowiedzialna za uruchamianie programu
 * @version 2.0.0
 * @author Delta
 */

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.informer.rest"})
public class BuildingInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
