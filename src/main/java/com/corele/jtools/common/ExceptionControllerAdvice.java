package com.corele.jtools.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liujun
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = {BaseException.class})
    public BaseResponse baseException(BaseException ex){
        return BaseResponse.baseResponse(ex.getErrorCode(),ex.getMessage(),null);
    }


    @ExceptionHandler(value = {IllegalArgumentException.class})
    public BaseResponse illegalArgumentException(IllegalArgumentException ex){
        return BaseResponse.baseResponse(0,ex.getMessage(),null);
    }
}
