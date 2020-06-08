package com.ljf.weifuwu.springcloud.ribbon.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonYmlConsumerApp
{
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main( String[] args )
    {    //ngix是服务端的负载均衡；ribbon是客户端的负载均衡器
        SpringApplication.run(RibbonYmlConsumerApp.class, args);
        System.out.println( "ribbon yml consumer启动起来了!" );
    }
}


