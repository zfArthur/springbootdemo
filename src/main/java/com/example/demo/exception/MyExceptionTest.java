package com.example.demo.exception;

import lombok.Data;

/**
 * @Author zhangfu
 * @Date 2020-10-02 11:47
 */
@Data
public class MyExceptionTest extends RuntimeException {
    private static final long serialVersionUID = -8817615173762463039L;
    private int code;
    private String message;
//    public MyExceptionTest(BizCodeEnum bizCodeEnum){
//        this.code = bizCodeEnum.getCode();
//        this.message = bizCodeEnum.getMessage();
//    }
}
