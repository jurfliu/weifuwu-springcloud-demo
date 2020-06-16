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
    @Value("${server.port}")
    private String port;
      @GetMapping("/msconfig-client")
      private String getProfileType() {
          System.out.println("ms-client获取的参数:"+profileType+" 远程name:"+name+" >>端口:"+port);
            return this.profileType+" >>"+name+" 端口:"+port;
       }
}
