package com.ljf.weifuwu.springcloud.eureka.consumer.controller;

import com.ljf.weifuwu.springcloud.eureka.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerUserController
{   @Autowired
private RestTemplate restTemplate;
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    @GetMapping("/consumer-eureka/{id}")
    public User findById(@PathVariable Long id) {
      // return this.restTemplate.getForObject("http://localhost:7900/eureka-provider/" + id, User.class);
        return this.restTemplate.getForObject("http://ms-eureka-provider/eureka-provider/" + id, User.class);
    }
}
