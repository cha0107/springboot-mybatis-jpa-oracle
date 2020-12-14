package com.transglobe.demo.http.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.transglobe.demo.constant.ResultCodeEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultEntity {
    @JsonProperty("code")
    private Integer code;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("data")
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

    public ResultEntity() {
        this.code = ResultCodeEnum.SUCCESS.code();
        this.message = ResultCodeEnum.SUCCESS.message();
    }

    /**
     * @param ResultCodeEnum
     */
    public ResultEntity(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code();
        this.message = resultCodeEnum.message();
    }
    
    /**
     * @param ResultCodeEnum
     * @param data
     */
    public ResultEntity(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.code();
        this.message = resultCodeEnum.message();
        this.data = data;
    }

    /**
     * @param data
     */
    public ResultEntity(Object data) {
        this.code = ResultCodeEnum.SUCCESS.code();
        this.message = ResultCodeEnum.SUCCESS.message();
        this.data = data;
    }

    /**
     * @param code
     * @param message
     */
    public ResultEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @param message
     * @param data
     */
    public ResultEntity(String message, Object data) {
        this.code = ResultCodeEnum.SUCCESS.code();
        this.message = message;
        this.data = data;
    }

    /**
     * @param code
     * @param message
     * @param data
     */
    public ResultEntity(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" + "code='" + code + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
