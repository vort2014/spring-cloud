package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("AccountService") // we take name from bootstap.yml of spring.application.name
public interface AccountServiceClient {

    // explicitly need to write @PathVarialble name
    @GetMapping("/checkout/{id}")
    boolean checkout(@PathVariable("id") Integer id, @RequestParam("sum") BigDecimal sum);
}
