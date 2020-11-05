package com.transglobe.demo.validation;

import org.junit.Test;
import com.transglobe.demo.http.error.ValidationError;

public class FieldValidatorTests {

    @Test
    public void testValidateNotNull() {
        FieldValidator.validateNotNull(100, "testParam");
    }

    @Test(expected = ValidationError.class)
    public void testValidateNotNullValidationError() {
        FieldValidator.validateNotNull(null, "testParam");
    }

    @Test
    public void testValidateNotEmpty() {
        FieldValidator.validateNotEmpty("testString", "testParam");
    }

    @Test(expected = ValidationError.class)
    public void testValidateNotEmptyValidationError() {
        FieldValidator.validateNotEmpty("", "testParam");
    }

    @Test
    public void testValidateMinLength() {
        FieldValidator.validateMinLength("testString", "testParam", 5);
    }

    @Test(expected = ValidationError.class)
    public void testValidateMinLengthValidationError() {
        FieldValidator.validateMinLength("testString", "testParam", 15);
    }

    @Test
    public void testValidateMaxLength() {
        FieldValidator.validateMaxLength("testString", "testParam", 15);
    }

    @Test(expected = ValidationError.class)
    public void testValidateMaxLengthValidationError() {
        FieldValidator.validateMaxLength("testString", "testParam", 5);
    }
}
