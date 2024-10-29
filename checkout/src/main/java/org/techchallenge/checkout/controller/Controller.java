package org.techchallenge.checkout.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class Controller {
    @GetMapping("checkout")
    public String test() {
        log.info("checkout!");
        return "checkout up";
    }
}
