package com.ljf.weifuwu.springcloud.hystrix.service;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import config.HystrixUserConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="ms-eureka-provider",configuration = HystrixUserConfig.class,fallbackFactory = HystrixFallBackFactory.class)
public interface HystrixUserFegin {
    //和ms-eureka-provider模块中的路径要保持一致/eureka-provider/{id}
    //  @GetMapping("/eureka-provider/{id}")
    //    public EurekaUser getSingleUser(@PathVariable Long id)
    @RequestLine("GET /eureka-provider/{id}")   //使用fegin的特用注解，确保 HystrixUserConfig这个自定义的配置类进行了配置
    public HystrixUser getSingleUser(@Param("id") Long id);
}
