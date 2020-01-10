package com.imooc.miaosha.exception;


import com.imooc.miaosha.domain.CodeMsg;
import com.imooc.miaosha.domain.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 自定义全局异常处理器
@ControllerAdvice  //自定义全局异常处理
public class GlobalExceptionHandler  {

    @ExceptionHandler(value = Exception.class) //声明指定异常处理方法
    @ResponseBody
    public Result handler(Exception exception){
        if(exception instanceof GlobalException){
            return Result.error( ((GlobalException)exception).getCodeMsg());
        }else{
            return Result.error(CodeMsg.SERVER_ERROR.getCode(),exception.getMessage());
        }


    }


}
