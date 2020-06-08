package com.ljf.weifuwu.springcloud.fegin.service;

import com.ljf.weifuwu.springcloud.fegin.model.FeginUser;
import config.UserFeginConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ms-eureka-provider",configuration = UserFeginConfig.class)
public interface UserFeginClientServvice {
    // 两个坑：1. 在feigin的接口中不能用GetMapping ,改为requestmapping method=rquestmethod.get  2. @PathVariable得设置@PathVariable（“xxx”）
   //@RequestMapping(value = "/eureka-provider/{id}", method = RequestMethod.GET)
   // public FeginUser getSingleUser(@PathVariable("id") Long id);
    @RequestLine("GET /eureka-provider/{id}")
    public FeginUser getSingleUser(@Param("id") Long id);
    //post请求
   // @RequestMapping(value="/eureka-user",method = RequestMethod.POST)
    @RequestLine("POST /eureka-user")
    public FeginUser getEurekaUserByPost(@RequestBody FeginUser user);

}
