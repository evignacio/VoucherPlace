package org.techchallenge.gestaocontas.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class GestaoController {
    @GetMapping("gestao")
    public String test() {
        log.info("getao!");
        return "gestao up";
    }
}
