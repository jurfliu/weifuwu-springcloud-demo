package com.ljf.weifuwu.springcloud.test.controller;





import com.ljf.weifuwu.springcloud.test.model.Eurekauser;
import com.ljf.weifuwu.springcloud.test.respository.EurekaUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private EurekaUserRespository userRepository;
        @GetMapping("/simpleuser/{id}")
    public Eurekauser findById(@PathVariable Long id) {
        return this.userRepository.findOne(id);
    }
}
