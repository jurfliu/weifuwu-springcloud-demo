package com.ljf.weifuwu.springcloud.zuul;

import com.ljf.weifuwu.springcloud.zuul.fallback.ZuulFallBackHandler;
import com.ljf.weifuwu.springcloud.zuul.filter.ChineseCharacterFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulConsumerApp

{

    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("500000KB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("1000000KB");
        return factory.createMultipartConfig();
    }
    @Bean
    public ZuulFallBackHandler myFallbackProvider() {
        return new ZuulFallBackHandler();
    }

    /**
     * 返回bean
     * @return
     */
    @Bean
    public ChineseCharacterFilter riskCheckFilter() {
        return new ChineseCharacterFilter();
    }
    public static void main(String args[]){
    SpringApplication.run(ZuulConsumerApp.class, args);
    System.out.println( "zuul启动起来了!" );
}

}
