package com.ljf.weifuwu.springcloud.ribbon.controller;

import com.ljf.weifuwu.springcloud.ribbon.model.EurekaUser;
import com.ljf.weifuwu.springcloud.ribbon.repository.EurekaUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonUserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaUserRespository userRepository;
    @GetMapping("/eureka-provider/{id}")
    public EurekaUser getSingleUser(@PathVariable Long id){
        System.out.println("我是 ribbon的提供者");
        return this.userRepository.findOne(id);

    }
}
