package com.ljf.weifuwu.springcloud.ribbon.controller;

import com.ljf.weifuwu.springcloud.ribbon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonUserController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer-ribbon/{id}")
    public User findById(@PathVariable Long id) {
        // return this.restTemplate.getForObject("http://localhost:7900/eureka-provider/" + id, User.class);
        return this.restTemplate.getForObject("http://ms-eureka-provider/eureka-provider/" + id, User.class);
    }
}
