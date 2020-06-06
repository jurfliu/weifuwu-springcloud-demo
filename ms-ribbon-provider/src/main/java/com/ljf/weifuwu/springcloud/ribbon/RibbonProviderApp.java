package com.ljf.weifuwu.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonProviderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(RibbonProviderApp.class,args);
        System.out.println( "ribbon中的提供者启动成功!" );
    }
}
