package com.imooc.miaosha.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisConfig {

    @Autowired
    RedisConfig redisConfig;

    @Test
    public void testRedisConfig(){
        System.out.println(redisConfig);
    }
}
