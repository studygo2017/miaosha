package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
}
