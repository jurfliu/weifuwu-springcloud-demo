package com.ljf.weifuwu.springcloud.ribbon.config;

import com.ljf.weifuwu.springcloud.ribbon.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
@ExcludeFromComponentScan
public class UserDefineConfig {
    //@Autowired
    //IClientConfig config;
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();//随机策略
    }
}
