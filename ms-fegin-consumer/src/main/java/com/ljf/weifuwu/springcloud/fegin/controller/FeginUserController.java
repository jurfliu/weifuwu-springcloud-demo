package com.ljf.weifuwu.springcloud.fegin.controller;

import com.ljf.weifuwu.springcloud.fegin.service.UserFeginClientServvice;
import com.ljf.weifuwu.springcloud.fegin.model.FeginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeginUserController
{
    @Autowired
    private UserFeginClientServvice ucs;

    /**
     * 这个是get请求
     * @param id
     * @return
     */
    @GetMapping("/fegin-consumer/{id}")
    public FeginUser findById(@PathVariable Long id) {
        System.out.println("feigin的get请求!!!!!!!!!!1"+id);
        FeginUser u= this.ucs.getSingleUser(id);
       System.out.println("u:"+u.getName());
        return this.ucs.getSingleUser(id);
    }

    /**
     * post请求
     * @returnet
     */
    @GetMapping("/fegin-consumer-post")
    public FeginUser findbyPost(FeginUser user) {
        //@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
        // GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，
        // 而是用POST方式进行提交。
        //http://localhost:8004/fegin-consumer-post?id=123&username=ljf&name=jurf
        // 为get方式不能加@RequestBody FeginUser user
        System.out.println("feigin的post请求!!!!!!!!!!1"+user.getId());
        return this.ucs.getEurekaUserByPost(user);
    }

}
