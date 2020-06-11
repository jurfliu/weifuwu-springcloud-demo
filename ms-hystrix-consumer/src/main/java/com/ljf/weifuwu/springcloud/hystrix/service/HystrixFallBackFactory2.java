package com.ljf.weifuwu.springcloud.hystrix.service;

import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HystrixFallBackFactory2 implements FallbackFactory<HystrixUserFegin2> {
    //日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixFallBackFactory2.class);
    @Override
    public HystrixUserFegin2 create(final Throwable throwable) {
        return new HystrixUserFegin2(){
            /**
             * 针对此方法，做的超时异常处理
             * @param id
             * @return
             */
            public HystrixUser getSingleUser2(Long id) {
                // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
                // 否则在引用启动时，就会打印该日志
                HystrixFallBackFactory2.LOGGER.info("fallback; reason was: ", throwable);
                System.out.println("超时发生错误的.....使用fegin-hystrix-facotry2进行处理");
                HystrixUser u=new HystrixUser();
                u.setId(00l);
                u.setName("fegin-hystrix-factory2-超时错误");
                return u;
            }
        };
    }

}
