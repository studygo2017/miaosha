package com.imooc.miaosha.service;

import com.alibaba.druid.util.StringUtils;
import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.CodeMsg;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.pojo.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    RedisService redisService;

    public User queryUserById(Long id){
        return userDao.queryById(id);
    }

    public int delById(Long id){
        return userDao.delById(id);
    }

    public int addUser(User user){
        return userDao.addUser(user);
    }

    @Transactional
    public int addUsers(){
        User ta = new User(10L, "ta","123");
        User tk = new User(1L, "tk","23456");
        int i = userDao.addUser(ta);
        int i1 = userDao.addUser(tk);
        if(i>0 && i1>0){
            return 200;
        }
        System.out.println("sss");
        return 400;
    }

    public boolean loginUser(HttpServletResponse response, User user) {
        //防止重复登录，在redis中查询是否有一样的key
        if( redisService.hasKey(UserKey.getMiaoshaToken,user.getName()) ){
            //刷新超时时间
            redisService.setExpiredTime(UserKey.getMiaoshaToken,user.getName(),UserKey.miaoshaExpiredTime);
            throw new GlobalException(CodeMsg.LOGINED_ALREADY);
        }

        if(user == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        User u = userDao.queryUserByName(user.getName());
        if(u == null){
            throw new GlobalException(CodeMsg.USERNAME_IS_NULL);
        }
        if(!StringUtils.equals(user.getPassword(),u.getPassword())){
            throw new GlobalException(CodeMsg.PASSWORD_IS_ERROR);
        }

        //登录逻辑成功，将key记录入redis
        redisService.set(UserKey.getMiaoshaToken,user.getName(),user,UserKey.miaoshaExpiredTime);
        //以token=(秒杀用户前缀加用户名)的形式 写入cookie响应给浏览器
        Cookie cookie = new Cookie("token",user.getName());
        cookie.setMaxAge(UserKey.miaoshaExpiredTime);
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }
}
