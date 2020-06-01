package com.ljf.weifuwu.springcloud.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaProviderApp.class,args);
        System.out.println( "eurka中的提供者启动成功!" );
    }
}
