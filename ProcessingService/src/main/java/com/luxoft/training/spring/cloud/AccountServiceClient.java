package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient
public interface AccountServiceClient {

    @GetMapping("/checkout/{id}")
    boolean checkout(@PathVariable Integer id, @RequestParam BigDecimal sum);
}
