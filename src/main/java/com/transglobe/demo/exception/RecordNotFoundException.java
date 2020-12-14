package com.transglobe.demo.exception;

import com.transglobe.demo.constant.ResultCodeEnum;

public class RecordNotFoundException extends RuntimeException 
{
    private Integer code;

    public RecordNotFoundException(String message) {
        super(message);
        this.code = ResultCodeEnum.RECORD_NOT_FOUND.code();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
