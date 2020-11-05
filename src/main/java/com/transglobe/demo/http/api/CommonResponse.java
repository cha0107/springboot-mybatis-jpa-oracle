package com.transglobe.demo.http.api;

import com.transglobe.demo.constant.ReturnStatus;

public class CommonResponse {

    private Integer code = ReturnStatus.SUCCESS.code();
    private String message = ReturnStatus.SUCCESS.message();
    private Object data;

    public Integer getCode() {
        return code;
    }



    public void setCode(Integer code) {
        this.code = code;
    }



    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }



    public Object getData() {
        return data;
    }



    public void setData(Object data) {
        this.data = data;
    }

    public CommonResponse() {
        this.setCode(ReturnStatus.SUCCESS.code());
        this.setMessage(ReturnStatus.SUCCESS.message());
    }

    /**
     * @param returnStatus
     */
    public CommonResponse(ReturnStatus returnStatus) {
        this.setCode(returnStatus.code());
        this.setMessage(returnStatus.message());
    }

    /**
     * @param data
     */
    public CommonResponse(Object data) {
        this.setCode(ReturnStatus.SUCCESS.code());
        this.setMessage(ReturnStatus.SUCCESS.message());
        this.setData(data);
    }

    /**
     * @param code
     * @param message
     */
    public CommonResponse(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    /**
     * @param message
     * @param data
     */
    public CommonResponse(String message, Object data) {
        this.setCode(ReturnStatus.SUCCESS.code());
        this.setMessage(message);
        this.setData(data);
    }

    /**
     * @param code
     * @param message
     * @param data
     */
    public CommonResponse(Integer code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }



    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
