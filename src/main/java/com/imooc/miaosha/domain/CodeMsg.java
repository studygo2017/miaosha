package com.imooc.miaosha.domain;

public enum CodeMsg {

    SERVER_ERROR(50001,"服务器异常！"),

    LOGINED_ALREADY(30001,"您已登录"),

    PASSWORD_IS_NULL(40401,"密码为空！"),
    PASSWORD_IS_ILLEGAL(40402,"密码格式错误!"),
    PASSWORD_IS_ERROR(40403,"用户名与密码不一致!"),
    USERNAME_IS_NULL(40404,"用户名不存在！"),
    USERNAME_IS_ILLEGAL(40405,"用户名非法");

    /** 响应码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
