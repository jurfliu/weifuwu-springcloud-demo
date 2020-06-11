package com.ljf.weifuwu.springcloud.hystrix.service;


import com.ljf.weifuwu.springcloud.hystrix.model.HystrixUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<HystrixUserFegin> {
    //日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixFallBackFactory.class);

    @Override
    public HystrixUserFegin create(final Throwable cause) {
        return new HystrixUserFegin(){
            /**
             * 针对此方法，做的超时异常处理
             * @param id
             * @return
             */
            @Override
            public HystrixUser getSingleUser(Long id) {
                // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
                // 否则在引用启动时，就会打印该日志
                HystrixFallBackFactory.LOGGER.info("fallback; reason was: ", cause);
                System.out.println("超时发生错误的.....使用fegin-hystrix-facotry进行处理");
                HystrixUser u=new HystrixUser();
                u.setId(00l);
                u.setName("fegin-hystrix-factory-超时错误");
                return u;
            }
        };
    }
}
