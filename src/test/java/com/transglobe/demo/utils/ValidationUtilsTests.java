package com.transglobe.demo.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidationUtilsTests {

    @Test
    public void testIsNumericReturnFalse() {
        boolean isNumericFlag = ValidationUtils.isNumeric("IsNotNumeric");
        assertEquals(false, isNumericFlag);
    }

    @Test
    public void testIsNumericReturnTrue() {
        boolean isNumericFlag = ValidationUtils.isNumeric("1091105");
        assertEquals(true, isNumericFlag);
    }
}
