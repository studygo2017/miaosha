package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

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
        User ta = new User(10L, "ta");
        User tk = new User(1L, "tk");
        int i = userDao.addUser(ta);
        int i1 = userDao.addUser(tk);
        if(i>0 && i1>0){
            return 200;
        }
        System.out.println("sss");
        return 400;
    }
}
