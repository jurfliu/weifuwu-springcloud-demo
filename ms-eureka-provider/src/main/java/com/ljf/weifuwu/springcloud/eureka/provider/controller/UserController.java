package com.ljf.weifuwu.springcloud.eureka.provider.controller;

import com.ljf.weifuwu.springcloud.eureka.provider.model.EurekaUser;

import com.ljf.weifuwu.springcloud.eureka.provider.respository.EurekaUserRespository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaUserRespository userRepository;
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        //和配置文件配置的application.name=ms-eureka-provider保持一致
        //获取配置文件的ip和端口号：http://localhost:7900/eureka-instance
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("ms-eureka-provider", false);
        return instance.getHomePageUrl();
    }
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        //http://localhost:7900/instance-info
        //"host":"192.168.1.225","port":7900,"serviceId":"ms-eureka-provider","metadata":{},"secure":false,"uri":"http://192.168.1.225:7900"}
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
    @GetMapping("/eureka-provider/{id}")
    public EurekaUser getSingleUser(@PathVariable Long id){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        System.out.println("我是 eureka的提供者");
        return this.userRepository.findOne(id);

    }
}
