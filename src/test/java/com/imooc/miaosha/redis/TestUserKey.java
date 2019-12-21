package com.imooc.miaosha.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserKey {

    @Test
    public void testAddExpiredTime(){
        UserKey userKey = UserKey.getIdKey;
        userKey.addExpiredTime((int)(0.5*60*60));
        int expiredTime = userKey.getExpiredTime();
        System.out.println(expiredTime);
    }
}
