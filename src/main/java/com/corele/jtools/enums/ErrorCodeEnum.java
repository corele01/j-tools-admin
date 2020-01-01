package com.corele.jtools.enums;

import lombok.Getter;

/**
 * @author liujun
 */
@Getter
public enum ErrorCodeEnum {
    /**
     * error
     */
    SUCCESS(1,"success"),
    FAIL(0,"fail"),;


    private int code;
    private String msg;

    ErrorCodeEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
