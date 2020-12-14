package com.transglobe.demo.exception;

import com.transglobe.demo.constant.ResultCodeEnum;

public class ValidationException extends RuntimeException {
    private Integer code;

    public ValidationException(String message) {
        super(message);
        this.code = ResultCodeEnum.VALIDATION_ERROR.code();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
