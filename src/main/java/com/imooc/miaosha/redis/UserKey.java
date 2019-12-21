package com.imooc.miaosha.redis;

import com.imooc.miaosha.domain.User;

public class UserKey extends BaseKey {

  /*  private String prefix;

    private int expiredTime;

    @Override
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getExpiredTime() {
        return expiredTime;
    }

    @Override
    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }
*/
    public static UserKey getGetIdKey() {
        return getIdKey;
    }

    public static UserKey getGetNameKey() {
        return getNameKey;
    }

    private UserKey(String prefix, int expiredTime) {
        super(prefix, expiredTime);
    }

    private UserKey(String prefix) {
        super(prefix);
    }

    private UserKey(int expiredTime) {
        super(expiredTime);
    }



    final public static UserKey getIdKey = new UserKey("id");

    final public static UserKey getNameKey = new UserKey("name");

    @Override
    public void addExpiredTime(int seconds) {
        super.addExpiredTime(seconds);
    }


}
