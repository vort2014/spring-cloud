package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CardService") // we take name from bootstap.yml of spring.application.name
public interface CardServiceClient {

    @GetMapping("/create")
    String create();
}
