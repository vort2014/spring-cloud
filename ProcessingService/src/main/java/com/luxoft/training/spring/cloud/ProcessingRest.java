package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProcessingRest {

    @Autowired
    private ProcessingRepository processingRepository;
    @Autowired
    private AccountServiceClient accountServiceClient;
    @Autowired
    private CardServiceClient cardServiceClient;

    @GetMapping("/issue/{accountId}")
    public ProcessingEntity issue(@PathVariable Integer accountId) {
        String card = cardServiceClient.create();
        return processingRepository.save(new ProcessingEntity(card, accountId));
    }

    // d point
//    @GetMapping("/checkout/{card}")
//    public boolean checkout(@PathVariable String card, @RequestParam BigDecimal sum) {
//        processingRepository.findByCard(card)
//    }
}
