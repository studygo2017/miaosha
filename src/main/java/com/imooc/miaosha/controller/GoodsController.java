package com.imooc.miaosha.controller;

import com.imooc.miaosha.pojo.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_goods")
    public ModelAndView goodsList(@CookieValue(name = "token",required = false) String token){
        ModelAndView mv = new ModelAndView();
//        mv.setViewName("goods");
        //判断redis中是否有相同的token,若有说明登陆过了，直接跳转，若无，说明未登录过
        if(redisService.hasKey(UserKey.getMiaoshaToken,token)){
            redisService.setExpiredTime(UserKey.getMiaoshaToken,token,30*60);
            //取出user数据，设置到Model的data域中
            User user = redisService.get(UserKey.getMiaoshaToken, token, User.class);
            mv.setViewName("goods");
            mv.addObject(user);
        }else{
            mv.setViewName("login");
        }

        return mv;
    }
}
