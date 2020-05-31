package com.ljf.weifuwu.simple.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SimpleProviderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(SimpleProviderApp.class,args);
        System.out.println( "简单模式下的服务提供者" );
    }
}
