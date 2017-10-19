package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface CardServiceClient {

    @GetMapping("/create")
    String create();
}
