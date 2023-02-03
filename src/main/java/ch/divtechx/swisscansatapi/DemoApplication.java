package ch.divtechx.swisscansatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ch.divtechx.swisscansatapi"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("""
                -------------------------------------
                |  API en cours de fonctionnement   |
                -------------------------------------""");
    }

}
