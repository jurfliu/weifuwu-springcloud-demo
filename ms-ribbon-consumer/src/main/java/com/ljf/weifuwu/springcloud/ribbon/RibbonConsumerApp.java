package com.ljf.weifuwu.springcloud.ribbon;

import config.UserDefineConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="ms-eureka-provider",configuration = UserDefineConfig.class)
public class RibbonConsumerApp
{
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main( String[] args )
    {    //ngix是服务端的负载均衡；ribbon是客户端的负载均衡器
        SpringApplication.run(RibbonConsumerApp.class, args);
        System.out.println( "ribbon consumer启动起来了!" );
    }
}
