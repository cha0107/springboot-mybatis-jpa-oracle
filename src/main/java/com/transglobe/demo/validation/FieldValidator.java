package com.transglobe.demo.validation;

import com.transglobe.demo.exception.ValidationException;


public class FieldValidator {
    public static void validateNotNull(Object o, String paramName) {
        if (o == null)
            throw new ValidationException(String.format("Missing required parameter '%s'", paramName));
    }

    public static void validateNotEmpty(String s, String paramName) {
        if (s == null || s.isEmpty())
            throw new ValidationException(String.format("Missing required parameter '%s'", paramName));
    }

    public static void validateMinLength(String s, String paramName, Integer minLength) {
        validateNotEmpty(s, paramName);

        if (s.length() < minLength)
            throw new ValidationException(String.format("Parameter '%s' must be at least %d characters", paramName, minLength));
    }

    public static void validateMaxLength(String s, String paramName, Integer maxLength) {
        validateNotEmpty(s, paramName);

        if (s.length() > maxLength)
            throw new ValidationException(String.format("Parameter '%s' must be at most %d characters", paramName, maxLength));
    }
}
