package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

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

    @GetMapping("/checkout/{card}")
    public boolean checkout(@PathVariable String card, @RequestParam BigDecimal sum) {
        ProcessingEntity processingEntity = processingRepository.findByCard(card);
        if (processingEntity == null) {
            return false;
        }
        return accountServiceClient.checkout(processingEntity.getId(), sum);
    }

    @GetMapping("/get")
    public Map<Integer, String> get(@RequestParam("accountId") List<Integer> accountIdList) {
        return processingRepository.findByAccountIdIn(accountIdList)
                .stream()
                .collect(toMap(ProcessingEntity::getAccountId, ProcessingEntity::getCard));
    }
}
