package com.ljf.weifuwu.springcloud.ha.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHaApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaHaApp.class,args);
        System.out.println( "EurekaHaApp 高可用启动成功了！！！" );
    }
}
