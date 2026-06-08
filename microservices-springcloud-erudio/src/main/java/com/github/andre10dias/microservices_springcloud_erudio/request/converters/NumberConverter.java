package com.github.andre10dias.microservices_springcloud_erudio.request.converters;

import com.github.andre10dias.microservices_springcloud_erudio.exception.UnsupportedMathOperationException;

public class NumberConverter {
    private NumberConverter() {
        /* This utility class should not be instantiated */
    }

    public static Double convertToDouble(String number) {
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value.");
        return Double.valueOf(number);
    }

    private static boolean isNumeric(String numberStr) {
        if (numberStr == null || numberStr.isEmpty()) return false;
        String number = numberStr.replace(",", ".");
        return number.matches("^-?\\d+(\\.\\d+)?$");
    }
}
