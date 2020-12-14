package com.transglobe.demo.exception;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.transglobe.demo.constant.ResultCodeEnum;
import com.transglobe.demo.http.api.ResultEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // @ExceptionHandler(value = {ValidationException.class})
    // public ResultEntity handleValidationException(ValidationException ex) {
    // logger.error("ValidationException: Error Code={}, Error Message={}", ex.getCode(),
    // ex.getMessage());
    // return new ResultEntity(ex.getCode(), ex.getMessage());
    // }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResultEntity handleRecordNotFoundException(RecordNotFoundException ex) {
        logger.warn("RecordNotFoundException: Error Code={}, Error Message={}", ex.getCode(), ex.getMessage());
        return new ResultEntity(ex.getCode(), ex.getMessage());
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder("[").append(ResultCodeEnum.VALIDATION_ERROR.message()).append("]：");
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            sb.append(((FieldError) error).getField()).append("：").append(error.getDefaultMessage()).append(", ");
        });
        return new ResultEntity(ResultCodeEnum.VALIDATION_ERROR, sb.toString());
        
//      Map<String, String> errors = new HashMap<>();
//      ex.getBindingResult().getAllErrors().forEach((error) -> {
//          String fieldName = ((FieldError) error).getField();
//          String errorMessage = error.getDefaultMessage();
//          errors.put(fieldName, errorMessage);
//      });
//      return new ResultEntity(ResultCodeEnum.VALIDATION_ERROR, errors);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResultEntity handleConstraintViolationException(ConstraintViolationException ex) {
        logger.warn("Exception: ", ex.getMessage());
        return new ResultEntity(ResultCodeEnum.VALIDATION_ERROR, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public ResultEntity handleException(Exception ex) {
        logger.warn("Exception: ", ex.getMessage());
        return new ResultEntity(ResultCodeEnum.ERROR.code(), ex.getMessage());
    }
}
