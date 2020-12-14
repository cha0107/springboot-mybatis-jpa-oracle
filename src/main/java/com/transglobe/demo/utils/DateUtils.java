package com.transglobe.demo.utils;

import com.transglobe.demo.exception.ValidationException;

public class DateUtils {
    public static Integer dateFromString(String intDate) {
        if (intDate == null) {
            throw new ValidationException(String.format("Uable to parse date %s", intDate));
        }
        if (!ValidationUtils.isNumeric(intDate)) {
            throw new ValidationException(String.format("Uable to parse date %s", intDate));
        }

        try {
            return Integer.parseInt(intDate);
        } catch (Exception e) {
            return null;
        }
    }
}
