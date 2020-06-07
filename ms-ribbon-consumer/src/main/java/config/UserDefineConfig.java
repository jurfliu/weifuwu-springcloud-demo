package config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class UserDefineConfig {
    @Autowired
    IClientConfig config;
    @Bean
    public IRule ribbonRule(IClientConfig  config){
        return new RandomRule();//随机策略
    }
}
