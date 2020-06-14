package com.ljf.weifuwu.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class ChineseCharacterFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";//类型为p
    }

    @Override
    public int filterOrder() {
        return 1;//过滤器排序为1号
    }

    /**
     * 判断是否执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;//执行该过滤器
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
         String URI = request.getRequestURI();
              if(URI.contains("/eureka-provider/")) {
                //获取RESTful风格请求URI"/user/findById/1" 中的“1"
                    String userName = URI.split("/")[3];
                   if(!StringUtils.isEmpty(userName)&&"china".equals(userName)) {
                        System.out.println("请求了UserId为"+userName+"的用户，有风险！！！");
                     }else {
                          System.out.println("请求了UserId不为china的用户，无风险~~");
                       }
                     }
             return null;


    }
}
