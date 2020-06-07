package com.ljf.weifuwu.springcloud.ribbon.controller;

import com.ljf.weifuwu.springcloud.ribbon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonUserController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer-ribbon/{id}")
    public User findById(@PathVariable Long id) {
        // return this.restTemplate.getForObject("http://localhost:7900/eureka-provider/" + id, User.class);
        return this.restTemplate.getForObject("http://ms-eureka-provider/eureka-provider/" + id, User.class);
    }
    @GetMapping("/usedefine-ribbon")
    public String show(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("ms-eureka-provider");
        System.out.println("随机:" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("ms-ribbon-provider");
        System.out.println("轮询：" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        return "1";
    }
}
