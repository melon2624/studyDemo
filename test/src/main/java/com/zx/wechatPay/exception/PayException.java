package com.zx.wechatPay.exception;


import com.zx.wechatPay.enums.ResultEnum;

public class PayException extends  RuntimeException{

    private Integer code;

    public PayException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }

    public PayException(Integer code, String message){
        super(message);
        this.code=code;
    }
}
