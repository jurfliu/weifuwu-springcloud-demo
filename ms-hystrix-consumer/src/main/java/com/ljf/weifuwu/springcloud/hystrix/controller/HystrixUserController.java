package com.ljf.weifuwu.springcloud.hystrix.controller;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import com.ljf.weifuwu.springcloud.hystrix.service.HystrixUserFegin;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HystrixUserController {
    @Autowired
    private HystrixUserFegin huf;
    /**
     * 这个是get请求
     * @param id
     * @return
     */
    @GetMapping("/hystrix-consumer/{id}")
    public HystrixUser queryInfoById(@PathVariable Long id) {
        System.out.println("hystrix的get请求!!!!!!!!!!1"+id);
        HystrixUser u= this.huf.getSingleUser(id);
        System.out.println("u:"+u.getName());
        return huf.getSingleUser(id);
    }


}
