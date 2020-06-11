package config;

import feign.Contract;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HystrixUserConfig2 {
    /**
     * 作用是让fegin不支持springmvc的注解,只能使用Feign自己的注解，而不能使用Spring MVC的注解了。
     * @return
     */

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();//只识别Feign的注释，不再识别Spring MVC的HTTP注释。
    }

    /**
     * 禁用单个fein使用hystrix
     * @return
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
