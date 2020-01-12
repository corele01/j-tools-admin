package com.corele.jtools.common;

import com.corele.jtools.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujun
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    private String errorMsg;
    private Integer errorCode = ErrorCodeEnum.FAIL.getCode();

    public BaseException(){
        super();
    }

    public BaseException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BaseException(Integer errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }


    public static BaseException exception(ErrorCodeEnum errorCodeEnum){
        return new BaseException(errorCodeEnum.getCode(),errorCodeEnum.getMsg());
    }

    public static BaseException exception(String errorMsg){
        return new BaseException(errorMsg);
    }

    public static BaseException exception(){
        return new BaseException();
    }
}
