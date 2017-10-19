package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardRest {

    @Autowired
    private CardNumberGenerator cardNumberGenerator;

    @GetMapping("/create")
    public String create() {
        return cardNumberGenerator.generate();
    }
}
