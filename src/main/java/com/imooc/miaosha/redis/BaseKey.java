package com.imooc.miaosha.redis;

public abstract class BaseKey implements KeyPrefix {
    private String prefix;

    //失效时间，单位为秒
    private int expiredTime = 0;

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public BaseKey(String prefix, int expiredTime) {
        this.prefix = prefix;
        this.expiredTime = expiredTime;
    }

    public BaseKey(String prefix) {
        this(prefix,0);
    }

    public BaseKey(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Override
    public String getPrefix() {
        return this.getClass().getSimpleName() + ":" + prefix + "-";
    }

    @Override
    public int getExpiredTime() {
        return expiredTime;
    }

    @Override
    public void addExpiredTime(int seconds){
        setExpiredTime(getExpiredTime()+seconds);
    }
}
