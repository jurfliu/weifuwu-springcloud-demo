package com.ljf.weifuwu.springcloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ConfigClientApp
{
    public static void main( String[] args ) {
        SpringApplication.run(ConfigClientApp.class, args);
        System.out.println("config client 启动成功了！！！");
    }
}
