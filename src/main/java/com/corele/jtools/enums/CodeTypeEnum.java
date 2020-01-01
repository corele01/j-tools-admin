package com.corele.jtools.enums;

import lombok.Getter;

/**
 * @author liujun
 */
@Getter
public enum CodeTypeEnum {
    /**
     * code type
     */
    JAVA(1,"java"),;

    private int code;
    private String msg;

    CodeTypeEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
