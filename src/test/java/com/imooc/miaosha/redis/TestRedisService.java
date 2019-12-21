package com.imooc.miaosha.redis;

import com.imooc.miaosha.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisService {
    @Autowired
    RedisService redisService;

    @Test
    public void testRedis(){
        /*
        boolean set = redisService.set("k1", "string2");
        System.out.println(set);
        */
        redisService.set(UserKey.getIdKey,"k1",1000L);
        String k1 = redisService.get(UserKey.getIdKey,"k1", String.class);
        boolean set = redisService.set(UserKey.getNameKey,"k5", new User(5L, "fv"));
        if( redisService.hasKey(UserKey.getNameKey,"k5") && set ){
            System.out.println(redisService.get(UserKey.getNameKey,"k5",User.class));
        }
        System.out.println(k1);
    }
}
