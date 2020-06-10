package config;

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
}

