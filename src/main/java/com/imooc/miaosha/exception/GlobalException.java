package com.imooc.miaosha.exception;

import com.imooc.miaosha.domain.CodeMsg;

public class GlobalException extends RuntimeException{

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
