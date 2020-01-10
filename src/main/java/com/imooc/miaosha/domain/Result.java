package com.imooc.miaosha.domain;

/**
 * 统一返回数据格式
 * @param <T>
 */
public class Result<T> {
    /** 响应码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 响应数据 */
    private T data;

    private Result() {
    }

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T t){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(t);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(CodeMsg codeMsg){
        Result result = new Result<>();
        result.setCode(codeMsg.getCode());
        result.setMsg(codeMsg.getMsg());
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
