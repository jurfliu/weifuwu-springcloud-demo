package com.ljf.weifuwu.springcloud.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class  SimpleConsumerApp
{
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main( String[] args )
    {
        SpringApplication.run(SimpleConsumerApp.class, args);
        System.out.println( "简单模式下，消费者启动成功！" );
    }
}
