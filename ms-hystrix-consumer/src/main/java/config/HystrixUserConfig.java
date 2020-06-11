package config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixUserConfig {
    /**
     * //feign配置日志
     * @return
     */
    @Bean
    public String showSmile() {
        String str="笑只是一种表情，与快乐无关，我是hystrix！！！";
        System.out.println(str);
        return str;
    }
    /**
     * 作用是让fegin不支持springmvc的注解,只能使用Feign自己的注解，而不能使用Spring MVC的注解了。
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();//只识别Feign的注释，不再识别Spring MVC的HTTP注释。
    }
}

