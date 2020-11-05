package com.transglobe.demo.http.error;

public class ValidationError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    public ValidationError(String message) {
        super(message);
    }

    public ValidationError(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
