package com.example.demo.exception;

import lombok.Getter;

/**
 * @Author zhangfu
 * @Date 2020-10-02 11:58
 */
@Getter
public enum  BizCodeEnum {

    APPOINT_BASIC_INVALID(1101,"超过字数限制");

    private Integer code;
    private String message;
    BizCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
