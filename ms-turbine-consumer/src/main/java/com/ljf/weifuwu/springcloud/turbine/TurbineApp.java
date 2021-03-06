package com.ljf.weifuwu.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(TurbineApp.class, args);
        System.out.println( "turbine启动起来了!" );
    }
}
