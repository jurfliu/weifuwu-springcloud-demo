package com.ljf.weifuwu.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(ConfigServerApp.class,args);
        System.out.println( "config server 启动成功了！！！" );
    }
}
