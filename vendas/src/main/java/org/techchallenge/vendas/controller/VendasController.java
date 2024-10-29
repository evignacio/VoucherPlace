package org.techchallenge.vendas.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.vendas.service.VendasService;

@RestController
@Log4j2
public class VendasController {

    private final VendasService vendasService;

    public VendasController(VendasService vendasService) {
        this.vendasService = vendasService;
    }

    @GetMapping("/test")
    public String test() {
        log.info("vendas!");
        return vendasService.message();
    }
}
