package com.imooc.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * @param prefix key的前缀
     * @param key redis数据的键
     * @param clazz 值数据的类型字节码
     * @param <T>
     * @return 按clazz字节码参数指定的对应类型返回v值
     */
    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            //根据连接池获取jedis连接对象,用完必须返还给连接池
            jedis = jedisPool.getResource();
            String value = jedis.get(prefix.getPrefix() + key);
            return stringToBean(value,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            returnToPool(jedis);
        }
        return null;
    }

    public <T> boolean set(KeyPrefix prefix,String key,T t,int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = objToString(t);
            //多并发上面，设置值和过期时间用了两步操作。故将设置值和过期时间合并成一步操作； NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒(见源码注释)
            jedis.set(prefix.getPrefix()+key,value,"NX","EX",seconds);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean set(KeyPrefix prefix,String key,T t){
        return this.set(prefix,key,t,0);
    }

    /**
     * 设置key的过期时间
     */
    public boolean setExpiredTime(KeyPrefix prefix,String key,int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key,seconds);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断key在redis中是否存在
     * @param key
     * @return
     */
    public boolean hasKey(KeyPrefix prefix,String key){
        Jedis jedis = null;
        Boolean exists = false;
        try {
            jedis = jedisPool.getResource();
            exists = jedis.exists(prefix.getPrefix()+key);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            returnToPool(jedis);
        }
        return exists;
    }

    private <T> String objToString(T t) {
        if(t == null){
            throw new RuntimeException("转换字符串方法的参数为null");
        }
        Class<?> clazz = t.getClass();
        //判断参数时哪种类型，根据不同的类型来转换为字符串
        if(clazz == Long.class || clazz == long.class || clazz == Integer.class || clazz == int.class || clazz == String.class){
            return t+"";
        }else{
            return JSON.toJSONString(t);
        }
    }


    private <T> T stringToBean(String value, Class<T> clazz) {
        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(value);
        }else if(clazz == long.class || clazz == Long.class){
            return (T) Long.valueOf(value);
        }else if(clazz == String.class){
            return (T) value;
        }else{
            return JSON.parseObject(value,clazz);
        }
    }


    //将jedis连接对象返回到连接池
    private void returnToPool(Jedis jedis){
        if(jedis!=null)
            jedis.close();
    }
}
