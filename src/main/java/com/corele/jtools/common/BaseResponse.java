package com.corele.jtools.common;

import com.corele.jtools.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private Integer code;
    private String message;
    private T data;

    public static BaseResponse<Object> baseResponse(Integer code,String message,Object data){
        return new BaseResponse<>(code,message,data);
    }

    public static BaseResponse<Object> baseResponse(ErrorCodeEnum codeEnum){
        return baseResponse(codeEnum.getCode(),codeEnum.getMsg(),"empty");
    }

    public static BaseResponse<Object> success(){
        return baseResponse(ErrorCodeEnum.SUCCESS);
    }
    public static <E> BaseResponse<E> success(E object){
        BaseResponse<E> res = new BaseResponse<>();
        res.setCode(ErrorCodeEnum.SUCCESS.getCode());
        res.setMessage(ErrorCodeEnum.SUCCESS.getMsg());
        res.setData(object);
        return res;
    }

    public static BaseResponse<Object> fail(){
        return baseResponse(ErrorCodeEnum.FAIL);
    }
}
