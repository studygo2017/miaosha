package com.imooc.miaosha.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

   /*
   redis.host=127.0.0.1
            #Redis服务器连接端口
    redis.port=6379
            #Redis服务器连接密码（默认为空）
    redis.password=
            #连接池最大连接数（使用负值表示没有限制）
    redis.pool.max-active=8
            #连接池最大阻塞等待时间（使用负值表示没有限制）
    redis.pool.max-wait=-1
            #连接池中的最大空闲连接
    redis.pool.max-idle=8
            #连接池中的最小空闲连接
    redis.pool.min-idle=0
            #连接超时时间（毫秒）
    spring.redis.timeout=30000
    */
   private String host;
   private int port;
   private String password;
   private int poolMaxTotal;
   private int poolMaxWait;
   private int poolMaxIdle;
   private int poolMinIdle;
   private int redisTimeout;

    public RedisConfig() {
    }

    public RedisConfig(String host, int port, String password, int poolMaxTotal, int poolMaxWait, int poolMaxIdle, int poolMinIdle, int redisTimeout) {
        this.host = host;
        this.port = port;
        this.password = password;
        this.poolMaxTotal = poolMaxTotal;
        this.poolMaxWait = poolMaxWait;
        this.poolMaxIdle = poolMaxIdle;
        this.poolMinIdle = poolMinIdle;
        this.redisTimeout = redisTimeout;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", poolMaxTotal=" + poolMaxTotal +
                ", poolMaxWait=" + poolMaxWait +
                ", poolMaxIdle=" + poolMaxIdle +
                ", poolMinIdle=" + poolMinIdle +
                ", redisTimeout=" + redisTimeout +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public int getPoolMinIdle() {
        return poolMinIdle;
    }

    public void setPoolMinIdle(int poolMinIdle) {
        this.poolMinIdle = poolMinIdle;
    }

    public int getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(int redisTimeout) {
        this.redisTimeout = redisTimeout;
    }
}
