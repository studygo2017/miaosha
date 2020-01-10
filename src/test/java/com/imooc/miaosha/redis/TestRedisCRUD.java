package com.imooc.miaosha.redis;

import com.imooc.miaosha.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisCRUD {

    @Autowired
    RedisService redisService;

    @Test
    public void testRedisSet(){
        redisService.set(UserKey.getMiaoshaToken,"ms_user_0",new User(null,"user0","123"));
    }

    @Test
    public void testRedisGet(){
        User user = redisService.get(UserKey.getMiaoshaToken, "ms_user_0", User.class);
        System.out.println(user);
    }
}
