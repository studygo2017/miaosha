package com.imooc.miaosha.redis;

/**
 * 前缀规范
 *  定义两个功能
 *    1. 前缀
 *    2. 控制失效时间
 *    3. 延长失效时间
 */
public interface KeyPrefix {
    String getPrefix();

    int getExpiredTime();

    void addExpiredTime(int seconds);
}
