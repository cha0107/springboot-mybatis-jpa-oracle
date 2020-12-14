package com.transglobe.demo.constant;

public enum ResultCodeEnum {

	SUCCESS(0, "Success"),
    ERROR(1001, "Error"),
    RECORD_NOT_FOUND(1002, "Record Not Found"),
	VALIDATION_ERROR(1003, "Validation Error");

	private Integer code;
	private String message;
	
    private ResultCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

}
