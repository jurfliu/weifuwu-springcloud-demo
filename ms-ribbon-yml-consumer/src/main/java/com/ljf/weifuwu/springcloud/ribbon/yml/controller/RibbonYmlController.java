package com.ljf.weifuwu.springcloud.ribbon.yml.controller;

import com.ljf.weifuwu.springcloud.ribbon.yml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class RibbonYmlController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer-ribbon/{id}")
    public User findById(@PathVariable Long id) {
                ServiceInstance serviceInstance = this.loadBalancerClient.choose("ms-eureka-provider");
              System.out.println("随机:" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return this.restTemplate.getForObject("http://ms-eureka-provider/eureka-provider/" + id, User.class);
    }
}
