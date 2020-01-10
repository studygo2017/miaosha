package com.imooc.miaosha.dao;

import com.imooc.miaosha.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User queryById(Long id);

    int delById(Long id);

    int addUser(User user);

    User queryUserByName(String spy);
}
