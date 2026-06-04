package com.github.andre10dias.microservices_springcloud_erudio.controllers;

import com.github.andre10dias.microservices_springcloud_erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number) {
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value.");
        return Double.valueOf(number);
    }

    private boolean isNumeric(String numberStr) {
        if (numberStr == null || numberStr.isEmpty()) return false;
        String number = numberStr.replace(",", ".");
        return number.matches("^-?\\d+(\\.\\d+)?$");
    }

}
