package com.ljf.weifuwu.springcloud.hystrix.service;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import config.HystrixUserConfig;
import config.HystrixUserConfig2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 当@FeignClient有name和url还有configuration时，取值为url的地址,name只是为一个名称而已(无意义)
  * 当@FeignClient只有name和configuration时，name的取值为eureka中的application项目的名称即虚拟地址
 */
@FeignClient(name="ms-eureka-provider2",url = "http://localhost:7901/",configuration = HystrixUserConfig2.class,fallbackFactory = HystrixFallBackFactory2.class)
public interface HystrixUserFegin2 {
    @RequestLine("GET /eureka-provider/{id}")   //使用fegin的特用注解，确保 HystrixUserConfig这个自定义的配置类进行了配置
    public HystrixUser getSingleUser2(@Param("id") Long id);
}
