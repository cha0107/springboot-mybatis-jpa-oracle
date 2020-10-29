package com.transglobe.demo.constant;

public enum ReturnStatus {

	SUCCESS(200, "SUCCESS_MSG"),
    ERROR(201, "ERROR_MSG"),
    NullpointerException(202, "NPE_MSG"),
    NullResponseException(203, "NRE_MSG");

	private Integer code;
	private String message;
	
    private ReturnStatus(Integer code, String message){
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
