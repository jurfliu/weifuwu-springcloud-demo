package com.ljf.weifuwu.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${city}")
   private String profileType;
    @Value("${spring.application.name}")
    private String name;
      @GetMapping("/msconfig-client")
      private String getProfileType() {
          System.out.println("ms-client获取的参数:"+profileType+" 远程name:"+name);
            return this.profileType+" >>"+name;
       }
}
