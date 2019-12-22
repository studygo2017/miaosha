package com.imooc.miaosha.redis;

import com.imooc.miaosha.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserKey {

    @Autowired
    RedisService redisService;

    @Test
    public void testAddExpiredTime(){
        UserKey userKey = UserKey.getIdKey;
        userKey.addExpiredTime((int)(10));
        int expiredTime = userKey.getExpiredTime();
        System.out.println(expiredTime);
        redisService.set(userKey,"test",new User(6L,"fv"));
        User user = redisService.get(userKey, "test", User.class);
        System.out.println(user);
    }
}
