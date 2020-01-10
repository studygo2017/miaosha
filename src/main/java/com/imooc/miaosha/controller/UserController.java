package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.Result;
import com.imooc.miaosha.pojo.User;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/query/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long id){
        User user = userService.queryUserById(id);
        return user;
    }

    @RequestMapping("/addUsers")
    @ResponseBody
    public int addUsers(){
        return userService.addUsers();
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(HttpServletResponse response, User user){
        //若抛出全局异常，由springmvc全局异常拦截处理
        userService.loginUser(response,user);
        return Result.success();
    }
}
