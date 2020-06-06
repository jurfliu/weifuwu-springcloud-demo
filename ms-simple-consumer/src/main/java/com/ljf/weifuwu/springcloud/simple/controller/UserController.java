package com.ljf.weifuwu.springcloud.simple.controller;

import com.ljf.weifuwu.springcloud.simple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    //调用配置文件中的参数
    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/userconsumer/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject(this.userServicePath + id, User.class);
        return this.restTemplate.getForObject("http://ms-simple-provider/simpleuser/" + id, User.class);
    }
}
