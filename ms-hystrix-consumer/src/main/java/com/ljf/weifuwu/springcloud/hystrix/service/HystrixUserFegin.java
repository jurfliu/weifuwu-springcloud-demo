package com.ljf.weifuwu.springcloud.hystrix.service;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import config.HystrixUserConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="ms-eureka-provider",configuration = HystrixUserConfig.class)
public interface HystrixUserFegin {
    //和ms-eureka-provider模块中的路径要保持一致/eureka-provider/{id}
    //  @GetMapping("/eureka-provider/{id}")
    //    public EurekaUser getSingleUser(@PathVariable Long id)
    @RequestMapping(value = "/eureka-provider/{id}", method = RequestMethod.GET)
    public HystrixUser getSingleUser(@PathVariable("id") Long id);
}
