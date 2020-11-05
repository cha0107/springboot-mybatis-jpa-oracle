package com.transglobe.demo.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DateUtilsTests {

    @Test
    public void testDateFromString() {
        Integer date = DateUtils.dateFromString("1091105");
        assertEquals(new Integer(1091105), date);
    }
}
