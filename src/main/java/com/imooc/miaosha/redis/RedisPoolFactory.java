package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisPoolFactory {
    @Autowired
    RedisConfig redisConfig;

    @Bean(name = "jedisPool")
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        jedisPoolConfig.setMinIdle(redisConfig.getPoolMinIdle());
        //不知道此处 连接的最大阻塞时间 单位是秒还是毫秒，就看JedisPoolConfig源码，去找源码里的参数注释
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
        /*public JedisPool(final GenericObjectPoolConfig poolConfig, final String host, int port,
        int timeout, final String password) {
            this(poolConfig, host, port, timeout, password, Protocol.DEFAULT_DATABASE, null);
        }*/
        return new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getRedisTimeout());
    }
}
