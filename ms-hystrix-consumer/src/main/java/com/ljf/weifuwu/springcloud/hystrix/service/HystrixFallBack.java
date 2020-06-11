package com.ljf.weifuwu.springcloud.hystrix.service;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import com.ljf.weifuwu.springcloud.hystrix.service.HystrixUserFegin;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBack implements HystrixUserFegin {
    /**
     * 针对此方法，做的超时异常处理
     * @param id
     * @return
     */
    @Override
    public HystrixUser getSingleUser(Long id) {
        System.out.println("超时发生错误的.....使用fegin-hystrix进行处理");
        HystrixUser u=new HystrixUser();
        u.setId(00l);
        u.setName("fegin-hystrix-超时错误");
        return u;
    }

}
