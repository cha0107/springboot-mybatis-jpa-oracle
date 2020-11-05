package com.transglobe.demo.utils;

import java.util.Optional;

public class ValidationUtils {
    public static boolean isNumeric(final String str) {
        return Optional.ofNullable(str).map(s -> s.chars().allMatch(Character::isDigit)).orElse(false);
    }
}
