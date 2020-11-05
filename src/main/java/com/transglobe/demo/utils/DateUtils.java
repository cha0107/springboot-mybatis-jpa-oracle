package com.transglobe.demo.utils;

import com.transglobe.demo.http.error.ValidationError;

public class DateUtils {
    public static Integer dateFromString(String intDate) {
        if (intDate == null) {
            throw new ValidationError(String.format("Uable to parse date %s", intDate));
        }
        if (!ValidationUtils.isNumeric(intDate)) {
            throw new ValidationError(String.format("Uable to parse date %s", intDate));
        }

        try {
            return Integer.parseInt(intDate);
        } catch (Exception e) {
            return null;
        }
    }
}
