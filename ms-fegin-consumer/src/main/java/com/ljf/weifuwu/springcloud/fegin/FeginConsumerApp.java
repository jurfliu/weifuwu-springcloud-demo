package com.ljf.weifuwu.springcloud.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeginConsumerApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(FeginConsumerApp.class, args);
        System.out.println( "fegin - consumer启动起来了!" );
    }
}
