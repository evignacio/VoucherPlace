package org.techchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "org.techchallenge")
@RestController
public class App {

    private final VendasService vendasService;

    public App(VendasService vendasService) {
        this.vendasService = vendasService;
    }

    @GetMapping("/test")
    public String test() {
        return vendasService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}